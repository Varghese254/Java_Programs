//interface
import java.io.*;
interface ishape
{
    public void draw();
    public void move();

}
class line implements ishape
{
    public void draw()
    {
        System.out.println("line is drawn");
    }
    public void move()
    {
        System.out.println("line is moved");
    }
}
class interfaceMain
{
    public static void main(String args[])
    {

        ishape i=new line();
        i.draw();
        i.move();
    }
    

}