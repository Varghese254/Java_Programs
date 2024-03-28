//roxie sinner prgrm to find largest among 3 numbers
class BigOfThre{
public static void main(String args[])
{
 int a=Integer.parseInt(args[0]);
int b=Integer.parseInt(args[1]);
int c=Integer.parseInt(args[2]);
int big=a;
if(b>big)
big=b;
if(c>big)
big=c;
System.out.println("biggest no:"+big);
}
}
