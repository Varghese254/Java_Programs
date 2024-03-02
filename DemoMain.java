//interface
import java.io.*;
interface i1
{
    void disp();
}
interface i2
{
    void print();
}
class Demo_interface implements i1,i2{
    public void disp()
    {
        System.out.println("hello i am in disp()");

    }
    public void print()
    {
        System.out.println("hello i am in print()");
    }
}
class DemoMain2
{
    Demo_interface D=new Demo_interface();
    D.disp();
    D.print();
}