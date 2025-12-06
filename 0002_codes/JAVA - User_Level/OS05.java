import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * OS05 - file creator and reader
 *
 * Idea to:
 * - asks the user for a file name
 * - asks the user to type some text
 * - saves the text into the file
 * - reads the file back and prints its contents
 */
public class OS05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("        OS05 - file create / read        ");
        System.out.println("=========================================");

        System.out.print("enter file name: ");
        String fileName = scanner.nextLine().trim();
        //
        if (fileName.isEmpty()) {
            System.out.println("file name cannot be empty");
            System.out.println("=========================================");
            return;
        }
        System.out.println("enter text to save in the file.");
        System.out.println("finish input with an empty line.");

        StringBuilder content = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            content.append(line).append(System.lineSeparator());
        }

        /* write text to file */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.out.println("could not write to file: " + e.getMessage());
            System.out.println("=========================================");
            return;
        }
        System.out.println();
        System.out.println("file saved. reading it back...\n");

        /* read file and print contents */
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("could not read file: " + e.getMessage());
            System.out.println("=========================================");
            return;
        }
        System.out.println("=========================================");
    }
}
