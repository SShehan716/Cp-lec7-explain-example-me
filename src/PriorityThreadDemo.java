public class PriorityThreadDemo {
    public static void main(String[] args) {
        Thread lowPriorityThread = new Thread(new Task(), "Low Priority Thread");
        Thread mediumPriorityThread = new Thread(new Task(), "Medium Priority Thread");
        Thread highPriorityThread = new Thread(new Task(), "High Priority Thread");

        // Set priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);   // Priority 1
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY); // Priority 5
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        // Start threads
        lowPriorityThread.start();
        mediumPriorityThread.start();
        highPriorityThread.start();

        // Delay to allow medium thread to run, then start a new high-priority thread
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread newHighPriorityThread = new Thread(new Task(), "New High Priority Thread");
        newHighPriorityThread.setPriority(Thread.MAX_PRIORITY);
        newHighPriorityThread.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " has completed execution.");
        }
    }
}
