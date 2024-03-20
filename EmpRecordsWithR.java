import java.sql.*;

public class EmpRecordsWithR {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Prepare the parameterized query
            String sql = "SELECT * FROM Emp WHERE ename LIKE ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Set the parameter for the query
            pstmt.setString(1, "R%"); // Names starting with 'R'

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Display the records
            System.out.println("Records in Emp table with names starting with 'R':");
            System.out.println("eno\tename\tesal\tdno");
            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                float esal = rs.getFloat("esal");
                int dno = rs.getInt("dno");
                System.out.println(eno + "\t" + ename + "\t" + esal + "\t" + dno);
            }

            // Close resources
            rs.close();
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
