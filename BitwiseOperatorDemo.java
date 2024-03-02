import java.io.*;
class BitwiseOperatorDemo
{
    public static void main(String args[])
    {

    
        int a=5;
        int b=3;
        int resultAND=a & b;
        System.out.println("result of bitwise  AND operation"+resultAND);
        int ResultOR= a | b;
        System.out.println("result of bitwise  OR operation"+ResultOR);
        int ResultXOR=a^b;
        System.out.println("result of bitwise  XOR operation"+ResultXOR);
        int leftshift=a<<2;
        System.out.println("result of bitwise  left shift operation"+leftshift);
        int num=6;
        int rightshift=num>>2;
        System.out.println("result of bitwise  left shift operation"+rightshift);


    }    
}