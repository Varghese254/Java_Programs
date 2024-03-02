    import java.io.*;
    interface i
    {
        public void disp();
        public void print();
    }
    class c1 implements i
    {
        public void disp()
        {
            System.out.println("interface disp");
        }
        public void print()
        {
                System.out.println("interface println");

        }
    }
    class M1
    {
        public static void main(String args[])
        {
            c1 obj=new c1();
            obj.disp();
            obj.print();
        }
    }