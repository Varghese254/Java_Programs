import java.io.*;
import java.util.*;
import java.sql.*;

class DBI {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement pstEmp = null;
        PreparedStatement pstDept = null;
        Scanner s = new Scanner(System.in);
        
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");
            
            // Prepare statements for both insertions
            pstEmp = con.prepareStatement("INSERT INTO emp (eno, ename, esal, dno) VALUES (?, ?, ?, ?)");
            pstDept = con.prepareStatement("INSERT INTO department (dno, dname, dloc) VALUES (?, ?, ?)");
            
            // Accept values from the user
            System.out.println("Enter employee details - eno, ename, esal, dno:");
            int eno = s.nextInt();
            s.nextLine(); // Consume newline left-over
            String ename = s.nextLine();
            float esal = s.nextFloat();
            int dno = s.nextInt();
            
            // Set parameters for the employee insertion
            pstEmp.setInt(1, eno);
            pstEmp.setString(2, ename);
            pstEmp.setFloat(3, esal);
            pstEmp.setInt(4, dno);
            
            // Execute employee insertion
            int empRowsAffected = pstEmp.executeUpdate();
            System.out.println(empRowsAffected + " record(s) inserted into EMP table.");
            
            // Accept values for department insertion
            System.out.println("Enter department details - dno, dname, dloc:");
            dno = s.nextInt();
            s.nextLine(); // Consume newline left-over
            String dname = s.nextLine();
            String dloc = s.nextLine();
            
            // Set parameters for the department insertion
            pstDept.setInt(1, dno);
            pstDept.setString(2, dname);
            pstDept.setString(3, dloc);
            
            // Execute department insertion
            int deptRowsAffected = pstDept.executeUpdate();
            System.out.println(deptRowsAffected + " record(s) inserted into DEPARTMENT table.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close resources in a finally block
            try {
                if (pstEmp != null) pstEmp.close();
                if (pstDept != null) pstDept.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
