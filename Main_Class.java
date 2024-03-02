import java.io.*;
class Staff
{
    int code;
    String name;

}
class Faculty extends Staff
{
    String depart;
    String sub;
    String research;

}
class Typist extends Staff
{
    String office_name;
    Float speed;
}
class Officer extends Staff
{
    int rank;
    String grade;

}
class Permanant extends Typist 
{
    Float sal;
}
class Casual extends Typist
{
    Float daily_wages;

}
class Main_Class
{
   
    public static void main(String args[])
    {
       
        try{
            DataInputStream din=new DataInputStream(System.in);

           // Staff S=new Staff();
            Faculty faculty=new Faculty();
            System.out.println("enter the code of faculty");
            faculty.code=Integer.parseInt(din.readLine());
            System.out.println("enter the name of the faculty");
            faculty.name=din.readLine();
            System.out.println("enter the department");
            faculty.depart=din.readLine();
            System.out.println("enter the subject");
            faculty.sub=din.readLine();
            System.out.println("enter the research area");
            faculty.research=din.readLine();

            //typist detials
            Typist typist=new Typist();
            System.out.println("Typist details...");
            System.out.println("Enter the office name");
            typist.office_name=din.readLine();
            System.out.println("Enter the typing speed");
            typist.speed=Float.parseFloat(din.readLine());

            //officer details
            Officer officer=new Officer();
            System.out.println("Officer details...");
            System.out.println("Enter the rank of officer");
            officer.rank=Integer.parseInt(din.readLine());
            System.out.println("Enter the grade of  officer");
            officer.grade=din.readLine();

            //Permanant
            Permanant permanant=new Permanant();
            System.out.println("Enter the salary");
            permanant.sal=Float.parseFloat(din.readLine());

            //casual
            Casual casual=new Casual();
            System.out.println("enter the daily wage");
            casual.daily_wages=Float.parseFloat(din.readLine());

            //printing the entered details
            System.out.println("faculty details.................");
            System.out.println("code:"+faculty.code);
            System.out.println("name:"+faculty.name);
            System.out.println("department:"+faculty.depart);
            System.out.println("subject:"+faculty.sub);
            System.out.println("research area:"+faculty.research);
            
            System.out.println("office:"+typist.office_name);
            System.out.println("typing speed:"+typist.speed);
            System.out.println("rank:"+officer.rank);
            System.out.println("grade:"+officer.grade);

            System.out.println("salary:"+permanant.sal);
            System.out.println("daily wages:"+casual.daily_wages);
        }catch(Exception e)
        {
            System.out.println("error"+e);
        }
    }
    
}