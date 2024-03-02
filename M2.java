import java.io.*;
interface i1
{
    public void disp();
    public void print();
}
class c2 implements i1{
    public void disp()
    {
        System.out.println("inside disp()");

    }
    public void print()
    {
        System.out.println("inside print()");
        
    }
}
class M2
{
     public static void main(String args[])
     {
        c2 obj=new c2();
        obj.disp();
        obj.print();
     }
}