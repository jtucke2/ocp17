package C15JDBC;

import java.sql.*;

public class StoredProcedureFun {
    public static void main(String[] args) {
        SqlRunner.runWithTable(StoredProcedureFun::storedProc);
    }

    public static Integer foo(int num) {
        System.out.println("Inside of foo 'procedure'");
        return 7 + num;
    }

    public static void storedProc(Connection connection) {
        try {
            try (Statement createStatement = connection.createStatement()) {
                // h2 can only alias Java methods
                createStatement.execute("""
                        CREATE ALIAS foo FOR "C15JDBC.StoredProcedureFun.foo"
                        """);
            }

            try (CallableStatement callableStatement = connection.prepareCall("{call foo(?) }")) {
                // INOUT param both share 1 index
                callableStatement.registerOutParameter(1, Types.INTEGER);
                callableStatement.setInt(1, 7);

                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    int retVal = resultSet.getInt(1);
                    System.out.println("Foo call returned: " + retVal);
                }
            }
            try (CallableStatement callableStatement = connection.prepareCall("{?=call foo(?) }")) {
                callableStatement.registerOutParameter(1, Types.INTEGER);
                // With separate OUT param, IN param is now index 2
                callableStatement.setInt(2, 7);

                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    int retVal = resultSet.getInt(1);
                    System.out.println("Foo call returned: " + retVal);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
