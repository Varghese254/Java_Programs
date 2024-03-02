//Write a Java program which creates a class named 'Employee' having the
// following members: Name, Age, Phone number, Address, Salary. 
//It also has a method named 'print- Salary( )' which prints the salary of the
// Employee. Two classes 'Officer' and 'Manager' inherits the 'Employee' class.
// The 'Officer' and 'Manager' classes have data members 'specialization' and 
//'department' respectively. Now, assign name, age, phone number, address and
// salary to an officer and a manager by making an object of both of these
// classes and print the same.
 
//creating  class employee
import java.io.*;
class Employee{
    String name;
    int age;
    double phone_no;
    Float sal;
    String address;
    public void printSalary()
    {
        System.out.println("salary of the employee"+sal);
    }
}
class Officer extends Employee
{
    String specialization;
}
class Manager extends Employee{
    String department;
}
class InheritanceMain
{
    public static void main(String args[])
    {
        DataInputStream din= new DataInputStream(System.in);
        Officer O=new Officer();
        Manager M=new Manager();

        try{
            System.out.println("enter the Officer details");
            System.out.println("enter the name");
            O.name=din.readLine();
            System.out.println("enter the age");
            O.age=Integer.parseInt(din.readLine());
            System.out.println("enter the address");
            O.address=din.readLine();
            System.out.println("enter the phone no");
            O.phone_no=Double.parseDouble(din.readLine());
            System.out.println("enter the salary");
            O.sal=Float.parseFloat(din.readLine());
            System.out.println("enter the specialization");
            O.specialization=din.readLine();


            //inputting manager details
            System.out.println("enter the Manager details");
            System.out.println("enter the name");
            M.name=din.readLine();
            System.out.println("enter the age");
            M.age=Integer.parseInt(din.readLine());
            System.out.println("enter the address");
            M.address=din.readLine();
            System.out.println("enter the phone no");
            M.phone_no=Double.parseDouble(din.readLine());
            System.out.println("enter the salary");
            M.sal=Float.parseFloat(din.readLine());
            System.out.println("enter the department");
            M.department=din.readLine();

            
        System.out.println("\nOfficer Details:");
        System.out.println("Name: " + O.name);
        System.out.println("Age: " + O.age);
        System.out.println("Phone Number: " + O.phone_no);
       System.out.println("Address: " + O.address);
         O.printSalary();
        System.out.println("Specialization: " + O.specialization);

        System.out.println("\nManager Details:");
        System.out.println("Name: " + M.name);
        System.out.println("Age: " + M.age);
        System.out.println("Phone Number: " + M.phone_no);
        System.out.println("Address: " + M.address);
        M.printSalary();
        System.out.println("Department: " + M.department);





        }catch(Exception e)
        {

        }
    }
}