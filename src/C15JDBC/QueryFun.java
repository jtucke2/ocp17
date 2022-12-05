package C15JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryFun {
    public static void main(String[] args) {
        SqlRunner.runWithTable(QueryFun::runQueries);
    }

    public static void runQueries(Connection conn) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM car WHERE make = ?")) {
            preparedStatement.setString(1, "Ford");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("yr");
                System.out.println(make + " ~ " + model + " ~ " + year);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
