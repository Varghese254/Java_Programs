import java.io.*;
class Serializable{
    public static void main(String args[]) throws Exception 
    {
        Student_serial s1=new Student_serial(100,"abcd");
        FileOutputStream fout=new FileOutputStream("f.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.flush();
        System.out.println("siuccess");
    }
}