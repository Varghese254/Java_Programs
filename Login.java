import java.io.*;
import java.util.*;
import java.sql.*;
class Login {
    public static void main(String[] args) {
        Connection con;
        Statement st;
        ResultSet rs;
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter UserName:");
            String username = s.nextLine();
            System.out.print("Enter Password:");
            String password = s.nextLine();

            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?characterEncoding=utf8", "root", ""); 
            st = con.createStatement();
            String str = "SELECT * FROM tbl_reg WHERE uname = '" + username + "' AND password = '" + password + "'";
            rs = st.executeQuery(str);
            if (rs.next()) {
                System.out.println("Login sucessfully");
            } else {
                System.out.println("invalid user..!");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
