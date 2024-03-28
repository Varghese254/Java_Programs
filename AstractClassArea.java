import java.io.DataInputStream;
abstract class Figure{
    int length,breadth,height;
    abstract int area(int x,int y);
    void getDataR(int x,int y)
    {
        length=x;
        breadth=y;
    }
    void getDataT(int x,int y)
    {
        breadth=x;
        height=y;
    }
    void putDataR()
    {
        System.out.println("length="+length);
        System.out.println("bredth="+breadth);

    }
    void putDataT()
    {
        System.out.println("breadth="+ breadth);
        System.out.println("heght="+height);
    }
}

class Rectangle extends Figure
{
    int area(int x,int y){
        return x*y;
    }
}

class Traingle extends Figure
{
    int area(int x,int y)
    {
        return (x*y)/2;
    }
}

class AbtractClassAreaDemo
{
    public void main(String args[])
    {
        try{
            DataInputStream in=new DataInputStream(System.in);
            Rectangle R=new Rectangle();
            Traingle T=new Traingle();
            int ch=0;
            do{
                 System.out.println("enter choice:1.Recatangle 2.Traingle 3.Exit");
                 ch=Integer.parseInt(in.readLine());
                 switch (ch) {
                    case 1:{
                        System.out.println("enter length and breadth of rectangle");
                        int l=Integer.parseInt(in.readLine());
                        int b=Integer.parseInt(in.readLine());
                        R.getDataR(l,b);
                        R.putDataR();
                        System.out.println("area of rect="+R.area(l,b));
                        break;
                    }
                        
                    case 2:{
                         System.out.println("enter the breadth and height of the traingle");
                         int b=Integer.parseInt(in.readLine());
                         int h=Integer.parseInt(in.readLine());
                         T.getDataT(b,h);
                         T.putDataT();
                         System.out.println("area of traingle="+T.area(b,h));
                         break;

                    }
                 }
            }
            

        }catch(Exception e){}
    }
}