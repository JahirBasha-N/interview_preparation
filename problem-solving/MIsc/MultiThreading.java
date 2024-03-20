package MIsc;

public class MultiThreading {
    private static class Worker extends Thread {
        private final String name;
        public Worker(String name) {
            this.name = name;
        }
        public void printState() {
            System.out.println(this.name + " " + this.getState());
        }

        @Override
        public void run() {
            synchronized (Worker.class) {
                System.out.println(name + " working");
                try {
                    Thread.sleep(2000);
                    if (name.equals("Worker 2")) { Worker.class.wait(); }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker("Worker 1");
        Worker worker2 = new Worker("Worker 2");

        worker1.printState();
        worker2.printState();

        worker1.start();
        Thread.sleep(500);

        worker1.join();
        worker2.start();

        worker1.printState();
        worker2.printState();

        Thread.sleep(3000);
        synchronized (Worker.class) { Worker.class.notifyAll(); }
        worker2.printState();
    }
}
