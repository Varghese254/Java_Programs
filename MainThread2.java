class MyThread extends Thread {
    public void run() {
        System.out.println("Thread: " + getName() + ", Priority: " + getPriority());
    }
}

public class MainThread2{
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        // Set priorities for threads
        thread1.setPriority(Thread.MIN_PRIORITY); // 1
        thread2.setPriority(Thread.NORM_PRIORITY); // 5
        thread3.setPriority(Thread.MAX_PRIORITY); // 10

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
