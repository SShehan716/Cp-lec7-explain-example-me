public class SelfishAndPoliteThreads {
    public static void main(String[] args) {
        // Create a thread that simulates selfish behavior
        Thread selfishThread = new Thread(new SelfishTask(), "Selfish Thread");

        // Create a thread that yields control to other threads
        Thread politeThread = new Thread(new PoliteTask(), "Polite Thread");

        // Start both threads
        selfishThread.start();
        politeThread.start();
    }

    // Class that defines the selfish thread task
    static class SelfishTask implements Runnable {
        @Override
        public void run() {
            // Loop 5 times without yielding, simulating selfish CPU usage
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is monopolizing CPU.");
            }
        }
    }

    // Class that defines the polite thread task
    static class PoliteTask implements Runnable {
        @Override
        public void run() {
            // Loop 5 times, yielding after each iteration to allow other threads to run
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is yielding.");
                Thread.yield(); // Suggest to the thread scheduler to give CPU time to other threads
            }
        }
    }
}
