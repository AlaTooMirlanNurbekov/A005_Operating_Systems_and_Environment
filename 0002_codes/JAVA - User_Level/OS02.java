import java.util.Scanner;

/*
 * OS02 - path breakdown tool
 * this program:
 * - reads the PATH environment variable
 * - splits it into separate directories
 * - prints each directory on a new line
 */

public class OS02 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("              OS02 - path                ");
        System.out.println("=========================================");

        /* get PATH variable */
        String path = System.getenv("PATH");

        if (path == null) {
            System.out.println("PATH variable not found");
            System.out.println("=========================================");
            return;
        }

        /* determine path separator */
        String separator;

        String osName = System.getProperty("os.name", "").toLowerCase();
        if (osName.contains("win")) {
            separator = ";";
        } else {
            separator = ":";
        }

        System.out.println("directories in PATH:\n");

        /* split and print each directory */
        String[] dirs = path.split(separator);

        for (String dir : dirs) {
            System.out.println(dir);
        }

        System.out.println("\n=========================================");
    }
}
