import java.io.*;
import java.net.URL*;
import java.util.*;

class UCDemo {
    public static void main(String args[]) throws Exception {
        int c;
        java.net.URL u = new java.net.URL("https://www.iitk.ac.in/esc101/share/downloads/javanotes5.pdf");
        java.net.URLConnection uc = u.openConnection();
        System.out.println("date:" + new java.util.Date(uc.getDate()));
        System.out.println("content type:" + uc.getContentType());
        System.out.println("Expires" + uc.getExpiration());
        System.out.println("last modified" + uc.getLastModified());
        int len = uc.getContentLength();
        System.out.println("content length" + len);
        if (len > 0) {
            FileOutputStream fout = new FileOutputStream("test.pdf");
            System.out.println("---content----");
            InputStream input = uc.getInputStream();
            int i = 0;
            while ((c = input.read()) != -1 && i < len) {
                fout.write((char) c);
                i++;
            }
            input.close();
            fout.close();
        } else {
            System.out.println("no content");
        }
    }
}
