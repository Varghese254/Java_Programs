//merge two file into a single one
import java.util.*;
import java.io.*;
class CopyFile
{
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        FileOutputStream fout;
        FileInputStream fin1,fin2;
        try
        {
            System.out.println("enter the name of file1");
            String file1=scanner.nextLine();
            fin1=new FileInputStream(file1);
            System.out.println("enter thr name of second file");
            String file2=scanner.nextLine();
            fin2=new FileInputStream(file2);
            System.out.println("enter the destination file");
            String file3=scanner.nextLine();
            fout=new FileOutputStream(file3);


            int n=fin1.read();
            while(n!=-1)
            {
                fout.write(n);
                n=fin1.read();
            }
            fout.write("\n".getBytes());
            n=fin2.read();
            while(n!=-1)
            {
                fout.write(n);
                n=fin2.read();
            }
            System.out.println("files merged successfully");

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
