// OS21 - process launcher
// This code starts an external command as a new process (to show how programs ask the OS to create processes)
import java.io.IOException;
import java.util.Scanner;

public class OS21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("         OS21 - process launcher         ");
        System.out.println("enter a command to run");
        System.out.println("type 'exit' to quit");
        System.out.println("=========================================");
        while (true) {
            System.out.print("os21> ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("leaving os21");
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
                System.out.println();
                System.out.println("process started");
                System.out.println("waiting for it to finish...");
                System.out.println();
                int exitCode = process.waitFor();
                System.out.println("process finished with exit code: " + exitCode);
                System.out.println();
            } catch (IOException e) {
                System.out.println("could not start process");
                System.out.println("reason: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("process interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("=========================================");
    }
}
