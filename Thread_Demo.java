//thread to print capital letters and small leters
class A extends Thread{
    public void run()
    {
        char ch='A';
        for(int i=1;i<=5;i++)
        {
            try{
                System.out.println(ch);
                ch++;
                sleep(2000);
            }catch(Exception e)
            {

            }
        }
    }
} 
class B extends Thread{
    public void run()
    {
        try{

        
        char c='a';
        for(int i=1;i<=5;i++)
        {
            System.out.println(c);
            c++;
            sleep(2000);
        }
    }catch(Exception e)
    {

    }
    }
}
class Thread_Demo
{
    public static void main(String args[])
    {
        A a=new A();
        B b=new B();
        a.start();
        b.start();
        
    }
}