import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement; // Import Statement
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class EncryptionDecryptionStoring {

    private static final String SECRET_KEY = "MySecretKey12345";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Options:");
            System.out.println("1. Encrypt file");
            System.out.println("2. Decrypt file");
            System.out.println("3. Compress file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the path of the input file: ");
                    String inputFile = scanner.nextLine();
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.nextLine();
                    try {
                        encryptAndStore(inputFile, fileName);
                        System.out.println("File encrypted and stored successfully.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Decryption code
                    break;
                case 3:
                    // Compression code
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }

    public static void encryptAndStore(String inputFile, String fileName) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, SQLException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) new File(inputFile).length()];
        inputStream.read(inputBytes);

        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        storeEncryptedFile(fileName, encryptedBytes);

        inputStream.close();
    }

    public static void storeEncryptedFile(String fileName, byte[] encryptedData) throws SQLException {
        Connection connection = null;
        Statement statement = null; // Change PreparedStatement to Statement
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
            statement = connection.createStatement(); // Use connection to create statement
            String query = "INSERT INTO tbl_file (file_name, file) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fileName);
            preparedStatement.setBytes(2, encryptedData);
            preparedStatement.executeUpdate();
            System.out.println("File encrypted and stored in database successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
