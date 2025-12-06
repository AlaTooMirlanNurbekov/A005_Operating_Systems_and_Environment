/*
 * OS17 - file permission checker
 *
 * shows read, write, execute flags for each file in current directory
 */
import java.io.File;
public class OS17 {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        File folder = new File(path);
        System.out.println("=========================================");
        System.out.println("        OS17 - permission checker        ");
        System.out.println("directory: " + path);
        System.out.println("=========================================");
        System.out.println("type  name");
        System.out.println("----  -------------------------------------------");

        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("could not list files");
            System.out.println("=========================================");
            return;
        }
        for (File f : files) {
            char type = f.isDirectory() ? 'd' : 'f';
            char r = f.canRead()    ? 'r' : '-';
            char w = f.canWrite()   ? 'w' : '-';
            char x = f.canExecute() ? 'x' : '-';

            System.out.printf("%c%3c%3c%3c  %s%n", type, r, w, x, f.getName());
        }
        System.out.println("=========================================");
    }
}
