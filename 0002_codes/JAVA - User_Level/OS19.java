/*
 * OS19 - safe directory cleaner
 *
 * deletes only empty directories inside the current working directory
 * teaches safe deletion practices with checks
 */
import java.io.File;
import java.util.Scanner;

public class OS19 {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        File folder = new File(path);
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("          OS19 - directory cleaner        ");
        System.out.println("current directory: " + path);
        System.out.println("=========================================");

        File[] list = folder.listFiles();

        if (list == null) {
            System.out.println("could not list directory");
            System.out.println("=========================================");
            return;
        }

        System.out.println("empty directories found:");
        int count = 0;

        for (File f : list) {
            if (f.isDirectory() && f.list() != null && f.list().length == 0) {
                System.out.println("- " + f.getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("none");
            System.out.println("=========================================");
            return;
        }
        System.out.println();
        System.out.print("delete all empty directories? (yes/no): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (!answer.equals("yes")) {
            System.out.println("no changes made.");
            System.out.println("=========================================");
            return;
        }
        for (File f : list) {
            if (f.isDirectory() && f.list() != null && f.list().length == 0) {
                boolean deleted = f.delete();
                if (deleted) {
                    System.out.println("deleted: " + f.getName());
                } else {
                    System.out.println("could not delete: " + f.getName());
                }
            }
        }
        System.out.println("=========================================");
    }
}
