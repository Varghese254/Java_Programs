import java.net.URL;

class URLDemo {
    public static void main(String args[]) throws Exception {
        URL url = new URL(args[0]);
        System.out.println("url is " + url.getProtocol());
        System.out.println("file name is " + url.getFile());
        System.out.println("host is " + url.getHost());
        System.out.println("port is " + url.getPort());
        System.out.println("default url " + url.getDefaultPort());
    }
}
