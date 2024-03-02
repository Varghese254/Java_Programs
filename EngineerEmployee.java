
//Write two Java classes Employee and Engineer. Engineer should inherit from Employee class.
// Employee class to have two methods display() and calcSalary().
// Write a program to display the engineer salary and to display from Employee class using a
//single object instantiation (i.e., only one object creation is allowed).  
import java.util.Scanner;
class Employee {
    double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println("Name of class is Employee.");
    }

    public double calcSalary() {
        return salary;
    }
}

class Engineer extends Employee {
    public Engineer(double salary) {
        super(salary);
    }


    public void display() {
        System.out.println("Name of class is Engineer.");
    }
}

public class EngineerEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Engineer's Salary:");
        double engineerSalary = scanner.nextDouble();
        scanner.nextLine();
        Engineer engineer = new Engineer(engineerSalary);
        engineer.display(); // Display Engineer's Salary
        // Displaying Employee's Salary using single object instantiation
        Employee emp = engineer;
        emp.display();
        scanner.close();
    }
}
