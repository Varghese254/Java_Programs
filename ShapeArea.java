import java.io.*;
class ShapeArea {
    public static void main(String args[])
    {
        DataInputStream din=new DataInputStream(System.in);
        try{
            int choice;
            do{
            System.out.println("1-Circle\n2-Rectangle\n3-Exit\nEnter the choice:");
            choice=Integer.parseInt(din.readLine());
            switch(choice)
            {
                case 1:
                        System.out.println("enter the radius of the circle");
                        float radius=Float.parseFloat(din.readLine());
                        Circle C=new Circle(radius);
                        System.out.println("Area of circle is"+C.calcarea());
                        break;
                case 2:
                        System.out.println("enter the length and breadh of the rectangle"); 
                        float lenghth=Float.parseFloat(din.readLine());
                        float breadh=Float.parseFloat(din.readLine());
                        Rectangle R=new Rectangle(lenghth,breadh);
                        System.out.println("area of the reactangle is "+R.calcarea());
                        break;
                case 3:System.out.println("exiting.....");
                        break;     
                default:
                        System.out.println("wrong input");
                        break;
            }
        } while(choice!=3);
        
        }catch(Exception e)
        {

        }

    }
}
class Circle
{
    float radius;
    public Circle(float radius)
    {
        this.radius=radius;
    }
    public Float calcarea()
    {
        return 3.14f*radius*radius;
    }
}
class Rectangle
{
    float lenghth,breadth;
    public Rectangle(float lenghth,float breadth)
    {
        this.lenghth=lenghth;
        this.breadth=breadth;
    }
    public Float calcarea()
    {
        return 2*(lenghth+breadth);
    }
}
