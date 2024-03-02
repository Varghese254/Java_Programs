import java.util.Scanner;
import java.util.NoSuchElementException; // Add this import statement
import java.sql.*;


public class MainPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. User Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (NoSuchElementException e) {
                // Handle the case where no input is provided
                System.out.println("No input provided. Exiting...");
                return;
            }
            
            switch (choice) {
                case 1:
                    userRegistration();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        
        scanner.close();
    }
    
    public static void userRegistration() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement();
                 Scanner scanner = new Scanner(System.in)) {
                System.out.println("User Registration:");
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
    
                String query = "INSERT INTO tbl_reg VALUES(" + id + ", '" + username + "', '" + password + "')";
                int rowsAffected = st.executeUpdate(query);
                System.out.println(rowsAffected + " record(s) inserted");
                
                // Call main() to display the menu again
                MainPage.main(null);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public static void login() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement();
                 Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                String query = "SELECT * FROM tbl_reg WHERE uname = '" + username + "' AND password = '" + password + "'";
                try (ResultSet rs = st.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println("Login successful");
                    } else {
                        System.out.println("Invalid user");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
