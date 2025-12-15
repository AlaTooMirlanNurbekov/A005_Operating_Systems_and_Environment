/*
 * OS26 - cpu work vs sleep
 * compares:
 * - a busy loop (burns cpu)
 * - a sleep loop (gives cpu back to the OS)
 */

public class OS26 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" OS26 - cpu busy vs sleep ");
        System.out.println("=========================================");
        System.out.println("part A: busy work for ~2 seconds");
        long busyStart = System.currentTimeMillis();

        long x = 0;
        while (System.currentTimeMillis() - busyStart < 2000) {
            x += 1; // pointless work, just keeps cpu busy
        }
        System.out.println("busy loop done, x = " + x);
        System.out.println();

        System.out.println("part B: sleep-based work for ~2 seconds");
        long sleepStart = System.currentTimeMillis();

        int ticks = 0;
        while (System.currentTimeMillis() - sleepStart < 2000) {
            ticks++;
            try {
                Thread.sleep(100); // not busy, OS can schedule others
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("sleep loop done, ticks = " + ticks);
        System.out.println("=========================================");
    }
}
