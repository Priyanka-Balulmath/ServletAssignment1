package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectQuery {
    public static void main(String[] args) {
        // Database connection parameters
    	  String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	        String username = "system";
	        String password = "orcl";
	        
        // SQL SELECT query
        String selectSQL = "SELECT ID, firstname, lastname,email FROM Employees";

        try {
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create a PreparedStatement object for executing the query
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            // Execute the query and get the ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                

                System.out.println("ID: " + id + ", Name: " + firstname + ",lastname:"+lastname + ", email: " + email);
            }

            // Close the ResultSet and the connection
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}