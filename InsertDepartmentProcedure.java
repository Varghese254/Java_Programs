import java.sql.*;

public class InsertDepartmentProcedure {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Prepare the call to the stored procedure
            String sql = "{CALL InsertDepartment(?, ?)}";
            CallableStatement cst = con.prepareCall(sql);

            // Set the parameters for the stored procedure
            cst.setString(1, "IT"); // Department name
            cst.setString(2, "New York"); // Department location

            // Execute the stored procedure
            cst.execute();

            // Close resources
            cst.close();
            con.close();

            System.out.println("Department record inserted successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
