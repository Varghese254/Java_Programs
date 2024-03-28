import java.io.DataInputStream;
class ArraySortExceptionDemo{
public static void main(String args[]){
try{
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter array length:");
int n=Integer.parseInt(in.readLine());
int a[]=new int[n];
System.out.println("Enter array elements:");
for(int i=0;i<n-1;i++)
a[i]=Integer.parseInt(in.readLine());
//sorting
for(int i=0;i<n-1;i++)
for(int j=i+1;j<n;j++)
{
if(a[i]>a[j])
{
int temp=a[i];
a[i]=a[j];
a[j]=temp;
}
}
System.out.println("Sorted array:");
for(int i=0;i<n;i++)
System.out.println(a[i]+" ");
}catch(Exception e){}
}
}