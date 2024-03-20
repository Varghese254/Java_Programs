import java.sql.*;

public class EmployeeInfoProcedure {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Prepare the call to the stored procedure
            String sql = "{CALL GetAllEmployeeInfo()}";
            CallableStatement cst = con.prepareCall(sql);

            // Execute the stored procedure
            ResultSet rs = cst.executeQuery();

            // Display the result set
            System.out.println("Ename\tEsal");
            while (rs.next()) {
                String ename = rs.getString("ename");
                float esal = rs.getFloat("esal");
                System.out.println(ename + "\t" + esal);
            }

            // Close resources
            rs.close();
            cst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
