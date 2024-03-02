//thread
class OddThread extends Thread{
    public void run()
    {
        for(int i=1;i<=100;i+=2)
        {
            System.out.println("odd thread:"+i);
        }
    }
}
class EvenThread extends Thread{
    public void run()
    {
        for(int i=0;i<100;i+=2)
        {
            System.out.println("even thread:"+i);
        }
    }
}
public class MainThread
{
    public static void main(String args[])
    {
        OddThread O=new OddThread();
        EvenThread E=new EvenThread();
        O.run();
        E.run();
        try{
            Thread.sleep(1000);
        }catch(Exception e)
        {

        }
        O.interrupt();
        E.interrupt();
        

    }
}