public class RaceSimulation {
    public static void main(String[] args) {
        Thread racer1 = new Thread(new Racer(), "Racer 1");
        Thread racer2 = new Thread(new Racer(), "Racer 2");

        // Assign priorities
        racer1.setPriority(Thread.MAX_PRIORITY); // Higher priority
        racer2.setPriority(Thread.MIN_PRIORITY); // Lower priority

        racer1.start();
        racer2.start();
    }

    static class Racer implements Runnable {
        private static volatile boolean raceOver = false;
        private int distanceCovered = 0;

        @Override
        public void run() {
            while (!raceOver && distanceCovered < 100) {
                distanceCovered++;
                System.out.println(Thread.currentThread().getName() + " has covered " + distanceCovered + " meters.");
                if (distanceCovered == 100) {
                    raceOver = true;
                    System.out.println(Thread.currentThread().getName() + " has won the race!");
                }
                Thread.yield(); // Yield to balance CPU time
            }
        }
    }
}
