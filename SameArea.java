//sameArea(Rectang to calculate the perimeter and area of the rectangle. Define another member functiole) 
//that has one parameter of type Rectangle. sameArea returns 1 if the two Rectangles have the same area,
// and returns 0 if they don't. Use appropriate constructors to initialize the member variables(Use both default
 // and parameterized constructor) Write a main function to create two rectangle objects and display its area
 // and perimeter. Check whether the two Rectangles have the same area and print a message indicating the result. (Use the concept of this pointer too) 

import java.io.*;
class Rectangle {
    int l, b;

    public Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    public int calcArea() {
        return l * b;
    }

    public int calcPerimeter() {
        return 2 * (l + b);
    }

    public void display() {
        System.out.println("Area: " + calcArea());
        System.out.println("Perimeter: " + calcPerimeter());
    }
}

class SameArea {
    public static void main(String args[]) {
        DataInputStream din = new DataInputStream(System.in);
        Rectangle R1, R2;

        try {
            System.out.println("Enter the length and breadth of rectangle 1:");
            int l1 = Integer.parseInt(din.readLine());
            int b1 = Integer.parseInt(din.readLine());
            R1 = new Rectangle(l1, b1);
            System.out.println("Rectangle 1:");
            R1.display();

            System.out.println("Enter the length and breadth of rectangle 2:");
            int l2 = Integer.parseInt(din.readLine());
            int b2 = Integer.parseInt(din.readLine());
            R2 = new Rectangle(l2, b2);
            System.out.println("Rectangle 2:");
            R2.display();
            if(R1.calcArea()==R2.calcArea())
            {
                System.out.println("area of both rectangles are same");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}
