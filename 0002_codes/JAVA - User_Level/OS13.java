
// OS13 - safe command runner (allows running only a small set of allowed commands)
// demonstrates controlled access to system functions

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OS13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* allowed commands */
        Set<String> allowed = new HashSet<>(Arrays.asList(
                "ls", // linux/mac
                "dir", // windows
                "whoami",
                "date"
        ));
        System.out.println("=========================================");
        System.out.println("           OS13 - safe runner            ");
        System.out.println("allowed commands: " + allowed);
        System.out.println("type 'exit' to stop");
        System.out.println("=========================================");

        while (true) {
            System.out.print("os13> ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                System.out.println("exiting os13");
                break;
            }
            if (!allowed.contains(input)) {
                System.out.println("command not allowed");
                continue;
            }
            try {
                ProcessBuilder builder = new ProcessBuilder(input.split(" "));
                builder.inheritIO();
                Process process = builder.start();
                process.waitFor();
            } catch (IOException e) {
                System.out.println("could not run command");
            } catch (InterruptedException e) {
                System.out.println("command interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("=========================================");
    }
}
