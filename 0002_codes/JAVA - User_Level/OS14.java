/*
 * OS14 - error code and exception viewer
 *
 * runs a system command and shows its exit code
 * prints basic exception information if something goes wrong
 */
import java.io.IOException;
import java.util.Scanner;

public class OS14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("      OS14 - error / exit code demo      ");
        System.out.println("=========================================");
        System.out.println("enter a command to run (or 'exit' to quit)");
        System.out.println();

        while (true) {
            System.out.print("os14> ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("leaving os14");
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            try {
                ProcessBuilder builder = new ProcessBuilder(parts);
                builder.inheritIO();
                Process process = builder.start();
                int exitCode = process.waitFor();

                System.out.println();
                System.out.println("command finished with exit code: " + exitCode);
                System.out.println();
            } catch (IOException e) {
                System.out.println();
                System.out.println("io exception while starting command");
                System.out.println("type   : " + e.getClass().getSimpleName());
                System.out.println("reason : " + e.getMessage());
                System.out.println();
            } catch (InterruptedException e) {
                System.out.println();
                System.out.println("command was interrupted");
                System.out.println("type   : " + e.getClass().getSimpleName());
                System.out.println("reason : " + e.getMessage());
                System.out.println();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("=========================================");
    }
}
