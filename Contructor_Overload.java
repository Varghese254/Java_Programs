//constructor overloading
import java.io.*;
class Rectangle
{
    int l,b;
    public Rectangle(int l,int b)
    {
        this.l=l;
        this.b=b;
    }
    public Rectangle(int s)
    {
        l=s;
        b=s;
    }
    public int CalcArea()
    {
        return l*b;
    }
}
class Contructor_Overload
{
    public static void main(String args[])
    {
        Rectangle rect=new Rectangle(3,4);
        Rectangle square=new Rectangle(6);
        try
        {
                System.out.println("area of rect="+rect.CalcArea());
                System.out.println("area of square="+square.CalcArea());


        }catch(Exception e)
        {
            
        }
    }
}