/*prgrm to find biggest number fromr an array*/
import java.io.DataInputStream;
class BiggArray{
public static void main(String args[])
{
 try{
DataInputStream in=new DataInputStream(System.in);
System.out.println("enter limit of arry");
int n=Integer.parseInt(in.readLine());
int a[]=new int[n];
System.out.println("enter array elements");
for(int i=0;i<n;i++)
a[i]=Integer.parseInt(in.readLine());
int big=a[0];
for(int i=0;i<n;i++)
{
 if(a[i]>big)
big=a[i];
}
System.out.println("biggest element of array:"+big);
}catch(Exception e){}
}
}
}


