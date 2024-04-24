//abstract class
import java.io.*;
abstract class First{
    abstract  void callme();
    void display()
    {
        System.out.println("inside 1st display method");
    }
}
class Second extends First{
    void callme()
    {
        System.out.println("inside call me metheod");
    }
}
class Abstract_Demo
{
    public static void main(String args[])
    {
        Second sec=new Second();
        sec.display();
        sec.callme();
    }
}