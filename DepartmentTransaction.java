import java.sql.*;

public class DepartmentTransaction {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Disable auto-commit to start a transaction
            con.setAutoCommit(false);

            // Create a Statement object
            stmt = con.createStatement();

            // Insert some records into the Department table with valid dno values
            stmt.executeUpdate("INSERT INTO Department (dno, dname, dloc) VALUES (4, 'IT', 'New York')");
            stmt.executeUpdate("INSERT INTO Department (dno, dname, dloc) VALUES (5, 'HR', 'London')");

            // Commit the transaction if all statements execute successfully
            con.commit();

            System.out.println("Transaction committed successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            // Rollback the transaction if any exception occurs
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error rolling back transaction: " + ex.getMessage());
            }
            System.out.println("Error: " + e.getMessage());
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
