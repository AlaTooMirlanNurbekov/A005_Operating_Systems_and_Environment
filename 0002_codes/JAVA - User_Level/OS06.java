import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * OS06 - error reporter and exception demo
 * - asks the user for a file name
 * - tries to open the file
 * - reports specific errors if the file cannot be opened
 * - demonstrates how java uses exceptions to signal problems
 */

public class OS06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("          OS06 - error reporter          ");
        System.out.println("=========================================");

        System.out.print("enter file name to open: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("file name cannot be empty");
            System.out.println("=========================================");
            return;
        }

        /* try to open the file and read the first line */
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String firstLine = reader.readLine();

            if (firstLine == null) {
                System.out.println("file is empty");
            } else {
                System.out.println("first line in file:");
                System.out.println(firstLine);
            }

        } catch (IOException e) {
            System.out.println("could not open file:");
            System.out.println("- reason: " + e.getMessage());
            System.out.println("- possible causes:");
            System.out.println("  * file does not exist");
            System.out.println("  * wrong path");
            System.out.println("  * no permission to read the file");
        }
        System.out.println("=========================================");
    }
}
