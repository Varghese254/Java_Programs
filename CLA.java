import java.io.*;

class CLA {
    public static void main(String args[]) throws Exception {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        if (args.length == 2) {
            try {
                fin = new FileInputStream(args[0]);
                fout = new FileOutputStream(args[1]);
                byte b[] = new byte[fin.available()]; // Corrected syntax
                fin.read(b);
                fout.write(b);
            } catch (Exception e) {
                e.printStackTrace(); // Added for error handling
            } finally {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            }
        } else {
            System.out.println("Usage: java CLA <source_file> <destination_file>");
        }
    }
}
