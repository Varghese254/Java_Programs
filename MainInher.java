import java.io.*;
class Person
{
     int age;
     String name;
     public void readp()
     {
        DataInputStream din=new DataInputStream(System.in);
        try{
            System.out.println("enter the name and age:");
            name=din.readLine();
            age=Integer.parseInt(din.readLine());

            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
     }
     public void disp()
        {
            System.out.println("name="+name+"age="+age);

        }
}
class Teacher extends Person
{
    String sub;
    public void readt()
    {
        DataInputStream din=new DataInputStream(System.in);
        try{
            System.out.println("enter the subject");
            sub=din.readLine();

        }catch(Exception e)
        {

        }
       
    }
    public void dispt()
    {
        System.out.println("subject="+sub);
        System.out.println("name="+name+"age="+age);

    }

}
class MainInher
{
    public static void main(String args[])
    {
        Person P;
        Teacher T;
        P=new Person();
        T=new Teacher();
        P.readp();
        T.readp();
        T.readt();
        P.disp();
        T.dispt();


    }
}