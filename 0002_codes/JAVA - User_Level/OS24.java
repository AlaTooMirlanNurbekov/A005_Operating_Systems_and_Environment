// OS24 - waiting styles
// Starts an external command and shows two ways to wait:
// 1) blocking wait (simple)
// 2) polling loop (you keep checking if it finished)
import java.io.IOException;
public class OS24 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" OS24 - waiting styles ");
        System.out.println("=========================================");
        ProcessBuilder pb = buildCommand();
        pb.inheritIO();

        try {
            System.out.println("starting process...");
            Process p = pb.start();
            // Option A block until it ends
    
            System.out.println("\n[A] blocking wait...");
            int codeA = p.waitFor();
            System.out.println("[A] finished, exit code = " + codeA);
        } catch (IOException e) {
            System.out.println("failed to start process");
            return;
        } catch (InterruptedException e) {
            System.out.println("interrupted while waiting");
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("\n-----------------------------------------\n");

        // run it again but this time we poll
        pb = buildCommand();
        pb.inheritIO();

        try {
            System.out.println("starting process again...");
            Process p = pb.start();

            System.out.println("\n[B] polling wait...");
            while (p.isAlive()) {
                System.out.println("[B] still running...");
                Thread.sleep(300); // small delay so we don't spam / burn CPU
            }
            int codeB = p.exitValue();
            System.out.println("[B] finished, exit code = " + codeB);
        } catch (IOException e) {
            System.out.println("failed to start process");
        } catch (InterruptedException e) {
            System.out.println("interrupted while polling");
            Thread.currentThread().interrupt();
        }
        System.out.println("=========================================");
    }
    private static ProcessBuilder buildCommand() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // takes about a second or two, good for demo
            return new ProcessBuilder("ping", "-n", "2", "127.0.0.1");
        } else {
            return new ProcessBuilder("sleep", "1");
        }
    }
}
