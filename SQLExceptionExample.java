import java.sql.*;

public class SQLExceptionExample {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Create a Statement object
            stmt = con.createStatement();

            // Execute a query that produces an SQLWarning
            ResultSet rs = stmt.executeQuery("SELECT * FROM NonExistentTable");

            // Retrieve any SQLWarnings associated with the ResultSet
            SQLWarning warning = rs.getWarnings();
            if (warning != null) {
                System.out.println("SQLWarning:");
                while (warning != null) {
                    System.out.println("Message: " + warning.getMessage());
                    System.out.println("SQLState: " + warning.getSQLState());
                    System.out.println("VendorError: " + warning.getErrorCode());
                    warning = warning.getNextWarning();
                }
            }

            // Close the ResultSet
            rs.close();
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("SQLException:");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: JDBC driver not found.");
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
