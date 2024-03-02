import java.io.*;
class Cthread extends Thread{
    int n;
    public Cthread(int a)
    {
        n=a;

    }
    public void run()
    {
        int i;
        for(i=1;i<=n;i++)
        {
            System.out.println("\ti="+i);
        }
    }
}
class CTread{
    public static void main(String args[]){
        Cthread t1,t2;
        t1=new Cthread(100);
        t2=new Cthread(150);
        System.out.println("B4 thread");
        t1.run();
        System.out.println("between threaD");
        t2.run();
        System.out.println("hello");
    }
}