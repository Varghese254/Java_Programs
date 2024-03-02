class Function_OverloadDemo {
    public static int add(int n1, int n2) {
         return n1 + n2;
    }
    public static int add(int n1, int n2, int n3) {
         return n1 + n2 + n3;
    }
}

class MainDEmoLoad {
    public static void main(String args[]) {
        try {
            System.out.println("Sum of two numbers: " + Function_OverloadDemo.add(3, 4));
            System.out.println("Sum of three numbers: " + Function_OverloadDemo.add(3, 4, 6));
        } catch(Exception e) {
            // Handle exceptions here
        }
    }
}
