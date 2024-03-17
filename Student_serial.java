import java.io.Serializable;
public class Student_serial implements Serializable {
    private transient int id;
    private String name;
    public Student_serial(int id, String name) {
        this.id = id;
        this.name = name;
    }    

    public void disp() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        // Instantiate a Student_serial object and display its information
        Student_serial student = new Student_serial(1, "John Doe");
        student.disp();
    }
}
  