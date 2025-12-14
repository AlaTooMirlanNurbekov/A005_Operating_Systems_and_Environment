import java.io.IOException;

/*
 * OS22 - parent child process simulation
 *
 * starts another java program as a child process
 * waits for it to finish and reports its exit code
 */

public class OS22 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("      OS22 - parent / child process      ");
        System.out.println("=========================================");

        try {
            /*
             * command assumes:
             * java OS22Child
             * OS22Child.java must be compiled first
             */
            ProcessBuilder builder =
                    new ProcessBuilder("java", "OS22Child");

            builder.inheritIO();

            System.out.println("parent: starting child process...");
            Process child = builder.start();

            System.out.println("parent: waiting for child to finish...");
            int exitCode = child.waitFor();

            System.out.println("parent: child finished with exit code " + exitCode);

        } catch (IOException e) {
            System.out.println("failed to start child process");
            System.out.println("reason: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("parent interrupted while waiting");
            Thread.currentThread().interrupt();
        }

        System.out.println("=========================================");
    }
}
