package oct_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql {
    private static final String URL = "jdbc:mysql://localhost:3306/test_db_poc"; // Ensure your database name is correct
    private static final String USER = "root"; // Your database username
    private static final String PASSWORD = "Root"; // Your database password

    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC Driver (this line is sometimes optional in newer
            // versions)
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure this class name matches the connector version

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MySQL DB successful");

            // Prepare the callable statement to call the stored procedure
            callableStatement = connection.prepareCall("{CALL GetDatabaseConfiguration()}");

            // Execute the stored procedure
            resultSet = callableStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String configName = resultSet.getString("config_name");
                String configValue = resultSet.getString("config_value");
                System.out.println(configName + ": " + configValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null)
                    resultSet.close();
                if (callableStatement != null)
                    callableStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
