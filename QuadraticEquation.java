import java.io.*;
class QuadraticEquation
{
    public static void main(String args[])
    {
        DataInputStream din=new DataInputStream(System.in);
        try{
            System.out.println("enter the coefficients of a,b,c");
            int a=Integer.parseInt(din.readLine());
            int b=Integer.parseInt(din.readLine());
            int c=Integer.parseInt(din.readLine());
            double n=b*b-4*a*c;
            if(n>0)
            {
                double root1=(-b+Math.sqrt(n))/(2*a);
                double root2=(-b-Math.sqrt(n))/(2*a);
                System.out.println("roots are real and dinstint");
                System.out.println("root1="+root1);
                System.out.println("root2="+root2);

            }
            else if(n==0)
            {
                double root=-b/(2*a);
                System.out.println("Roots are real and dinstint"+root);
            }
            else
            {
                double realpart=-b/(2*a);
                double imaginarypart=Math.sqrt(-n)/(2*a);
                System.out.println("Root 1 = " + realpart + " + " + imaginarypart + "i");
                System.out.println("Root 2 = " + realpart + " - " + imaginarypart + "i");
            }


        }catch(Exception e)
        {

        }
    }
}