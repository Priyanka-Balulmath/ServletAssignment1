package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	        // Database URL, username, and password
	        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	        String username = "system"; 
	        String password = "orcl"; 

	            // Load Oracle JDBC Driver
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            String createTableSQL = "CREATE TABLE users ("
	                    + "username VARCHAR2(50), "
	                    + "password VARCHAR2(50), "
	                    + "Email VARCHAR2(100))";
	            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	                    Statement statement = connection.createStatement()) {

	                // Execute the SQL statement
	                statement.execute(createTableSQL);
	                System.out.println("Table 'Employees' created successfully.");
	                connection.close();
	                statement.close();
	            }

	          
	         
	    }
}
