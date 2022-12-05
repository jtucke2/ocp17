package C15JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class SqlRunner {
    static final String DB_URL = "jdbc:h2:mem:";

    public static void runWithTable(Consumer<Connection> consumer) {
        try (Connection conn = DriverManager.getConnection(DB_URL, "sa", "")) {

            try (
                    PreparedStatement createStatement = conn.prepareStatement("""
                            CREATE TABLE car
                            (
                                make VARCHAR(255) NOT NULL,
                                model VARCHAR(255) NOT NULL,
                                yr INT,
                                PRIMARY KEY(make, model)
                            );
                            """)
            ) {
                createStatement.execute();
            }

            try (PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO car VALUES (?, ?, ?)")) {
                List.of(
                        List.of("Ford", "Mustang", 2002),
                        List.of("Ford", "F-150", 2009),
                        List.of("Chevy", "Camaro", 2012),
                        List.of("Chevy", "Suburban", 2010),
                        List.of("BMW", "M3", 2019)
                ).forEach(props -> {
                    try {
                        insertStatement.setString(1, props.get(0).toString());
                        insertStatement.setString(2, props.get(1).toString());
                        insertStatement.setInt(3, Integer.parseInt(props.get(2).toString()));
                        insertStatement.addBatch();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
                insertStatement.executeBatch();
            }

            consumer.accept(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
