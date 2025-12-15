/*
 * OS25 - background task simulator
 * Starts an external process and does not wait immediately the "parent" keeps working while the child runs.
 */
import java.io.IOException;
public class OS25 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" OS25 - background task simulator ");
        System.out.println("=========================================");
        ProcessBuilder pb = buildCommand();
        pb.inheritIO();

        try {
            System.out.println("starting child process...");
            Process child = pb.start();

            System.out.println("parent: not waiting yet, doing some work...\n");

            for (int i = 1; i <= 10; i++) {
                System.out.println("parent: working step " + i);
                Thread.sleep(250);
            }
            System.out.println("\nparent: now checking if child is still alive...");
            if (child.isAlive()) {
                System.out.println("child is still running, waiting for it to finish...");
                int exit = child.waitFor();
                System.out.println("child finished, exit code = " + exit);
            } else {
                int exit = child.exitValue();
                System.out.println("child already finished, exit code = " + exit);
            }

        } catch (IOException e) {
            System.out.println("failed to start child process");
        } catch (InterruptedException e) {
            System.out.println("interrupted");
            Thread.currentThread().interrupt();
        }
        System.out.println("=========================================");
    }
    private static ProcessBuilder buildCommand() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            //takes a couple seconds, good for background demo
            return new ProcessBuilder("ping", "-n", "4", "127.0.0.1");
        } else {
            return new ProcessBuilder("sleep", "2");
        }
    }
}
