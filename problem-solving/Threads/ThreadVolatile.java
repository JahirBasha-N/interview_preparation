package Threads;

public class ThreadVolatile {
    static int count = 0;
    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("***********thread one*********** starts " + count + " flag " + flag);
            flag = true;
            while (flag) {
                count++;
                if (count > 10) break;
                System.out.println("thread one count increase " + count);
            }
            System.out.println("thread one count ends*********** " + count);
        });
        Thread thread1 = new Thread(() -> {
            System.out.println("***********thread two*********** starts " + count + " flag " + flag);
            while (flag) {
                count++;
                if (count > 10) break;
                System.out.println("thread two count increase " + count);
            }
            System.out.println("thread two count ends*********** " + count);
        });
        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        Runnable runnable = () -> {
            int start = 0;
            while (start < 10) start++;
            System.out.println(start);
        };
        thread = new Thread(runnable);
        synchronized (runnable) {
            thread1 = new Thread(runnable);
            thread1.start();
        };
        thread.getState();
    }
}
