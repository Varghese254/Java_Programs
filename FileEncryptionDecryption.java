
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncryptionDecryption {

    // Change this to your own 16-byte secret key
    private static final String SECRET_KEY = "MySecretKey12345";

    public static void main(String[] args) {
        String inputFile = "InheritanceMain.java";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";

        try {
            // Encrypt the file
            encrypt(inputFile, encryptedFile);
            System.out.println("File encrypted successfully.");

            // Decrypt the file
            decrypt(encryptedFile, decryptedFile);
            System.out.println("File decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void encrypt(String inputFile, String outputFile) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) new File(inputFile).length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

    public static void decrypt(String inputFile, String outputFile) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) new File(inputFile).length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}