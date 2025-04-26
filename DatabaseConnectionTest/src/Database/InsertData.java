package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) {
		   String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	        String username = "system";
	        String password = "orcl";

	        // SQL INSERT query
	        String insertSQL = "INSERT INTO Employees (ID, firstname, lastname,email) VALUES (?, ?, ?,?)";

	        try {
	            // Establish the connection to the database
	            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

	            // Create a PreparedStatement object for executing the query
	            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

	            // Set the values for the placeholders
	            preparedStatement.setInt(1, 1); // ID
	            preparedStatement.setString(2, "John "); // Name
	            preparedStatement.setString(3, "Doe"); // lastname
	            preparedStatement.setString(4, "john@email.com");

	            // Execute the query
	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("Rows inserted: " + rowsAffected);

	            // Close the connection
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


}
