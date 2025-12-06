// OS18 - file copier
// copies the content of one file into another file
// Shows basic file input/output operations
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OS18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("              OS18 - copier              ");
        System.out.println("=========================================");
        System.out.print("source file: ");
        String source = scanner.nextLine().trim();

        System.out.print("destination file: ");
        String destination = scanner.nextLine().trim();

        if (source.isEmpty() || destination.isEmpty()) {
            System.out.println("invalid file names");
            System.out.println("=========================================");
            return;
        }

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }
            System.out.println();
            System.out.println("file copied successfully.");

        } catch (IOException e) {
            System.out.println();
            System.out.println("copy failed.");
            System.out.println("reason: " + e.getMessage());
        }

        System.out.println("=========================================");
    }
}
