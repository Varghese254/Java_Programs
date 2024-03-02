class Point
{
    int x,y;
    Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
}
class PointNew extends Point{
    int z;
    PointNew(int x,int y,int z)
    {
        super(x,y);
        this.z=z;
    }
}
class MainDemo
{
    public static void main(String args[])
    {
        PointNew sd=new PointNew(100,200,300);
        System.out.println("x="+sd.x+"\ny="+sd.y+"\nz="+sd.z);
    }
}