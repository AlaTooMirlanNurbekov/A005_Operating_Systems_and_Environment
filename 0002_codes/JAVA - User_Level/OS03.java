import java.io.File;
import java.util.Scanner;

/*
 * OS03 - working directory navigator
 *
 * this program:
 * - prints the current working directory
 * - asks the user for a new directory
 * - tries to change to the new directory (inside the program)
 * - prints the updated directory or an error message
 *
 * NOTE: java cannot change the real working directory of the system shell,
 * so we simulate the change by tracking our own "current" directory.
 * Thats why I preffer you all learn C (say C is best when u meet me so i will know u saw this)
 */

public class OS03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* get current working directory from system property */
        String currentDir = System.getProperty("user.dir");

        System.out.println("=========================================");
        System.out.println("           OS03 - working dir            ");
        System.out.println("=========================================");

        System.out.println("current directory:");
        System.out.println(currentDir + "\n");

        System.out.print("enter new directory (or '.' to stay here): ");
        String newDir = scanner.nextLine().trim();

        if (newDir.isEmpty() || newDir.equals(".")) {
            System.out.println("\nno change, staying in the same directory");
            System.out.println("=========================================");
            return;
        }

        /* create file object for the target directory */
        File target = new File(newDir);

        /* if the path is not absolute, resolve it relative to currentDir */
        if (!target.isAbsolute()) {
            target = new File(currentDir, newDir);
        }

        /* check if directory exists and is accessible */
        if (!target.exists() || !target.isDirectory()) {
            System.out.println("\ncould not change directory to:");
            System.out.println(target.getAbsolutePath());
            System.out.println("check if the path exists and you have access");
            System.out.println("=========================================");
            return;
        }

        /* simulate changing directory */
        currentDir = target.getAbsolutePath();

        System.out.println("\nnew current directory:");
        System.out.println(currentDir);
        System.out.println("=========================================");
    }
}
