/*
 * OS22Child - child process
 * program that runs briefly and exits
 */
public class OS22Child {

    public static void main(String[] args) {

        System.out.println("child: running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("child interrupted");
        }

        System.out.println("child: exiting");
    }
}
