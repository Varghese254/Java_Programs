import java.sql.*;

public class DisplayInfo {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");
            Statement st = con.createStatement();

            // Execute query to fetch information from both tables
            ResultSet rs = st.executeQuery("SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
                                           "FROM Emp e INNER JOIN Department d ON e.dno = d.dno");

            // Display information in the specified order
            System.out.println("eno\tename\tesal\tdname\tdloc");
            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                float esal = rs.getFloat("esal");
                String dname = rs.getString("dname");
                String dloc = rs.getString("dloc");
                System.out.println(eno + "\t" + ename + "\t" + esal + "\t" + dname + "\t" + dloc);
            }

            // Close resources
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
