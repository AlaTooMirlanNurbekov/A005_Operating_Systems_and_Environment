import java.io.IOException;
import java.util.Scanner;

/*
 * OS04 - basic command interpreter
 * This program:
 * - shows a simple command prompt
 * - reads a command from the user
 * - runs the command using the operating system
 * - exits when the user types "exit" or "quit"
 */

public class OS04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("=========================================");
        System.out.println("        OS04 - basic interpreter         ");
        System.out.println("type commands to run them");
        System.out.println("type 'exit' or 'quit' to leave");
        System.out.println("=========================================");

        while (true) {
            System.out.print("os04> ");
            command = scanner.nextLine().trim();

            if (command.isEmpty()) {
                continue;
            }

            if (command.equals("exit") || command.equals("quit")) {
                System.out.println("exiting os04");
                break;
            }

            try {
                /* split the command for ProcessBuilder */
                String[] parts = command.split("\\s+");

                ProcessBuilder builder = new ProcessBuilder(parts);
                builder.inheritIO(); // show output directly in console

                Process process = builder.start();
                process.waitFor();

            } catch (IOException e) {
                System.out.println("could not run command");
            } catch (InterruptedException e) {
                System.out.println("command execution interrupted");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("=========================================");
    }
}
