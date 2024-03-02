import java.io.*;
import java.net.*;
import java.util.*;

class UCDemoVideo {
    public static void main(String args[]) throws Exception {
        int c;
        URL u = new URL("I");
        URLConnection uc = u.openConnection();
        System.out.println("date:" + new Date(uc.getDate()));
        System.out.println("content type:" + uc.getContentType());
        System.out.println("Expires" + uc.getExpiration());
        System.out.println("last modified" + uc.getLastModified());
        int len = uc.getContentLength();
        System.out.println("content length" + len);
        if (len > 0) {
            FileOutputStream fout = new FileOutputStream("sample-video.mp4");
            System.out.println("---content----");
            InputStream input = uc.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesRead);
            }
            input.close();
            fout.close();
        } else {
            System.out.println("no content");
        }
    }
}
