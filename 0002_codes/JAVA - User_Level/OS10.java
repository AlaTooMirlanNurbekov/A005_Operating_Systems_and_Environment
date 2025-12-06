import java.io.File;
/* OS10 - directory tree printer
 prints all files and folders under a given directory
 * shows how the operating system structures files in a hierarchy*/

public class OS10 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("           OS10 - directory tree         ");
        System.out.println("=========================================");
        String startPath = System.getProperty("user.dir");
        System.out.println("starting from: " + startPath + "\n");

        printTree(new File(startPath), 0);
        System.out.println("=========================================");
    }

    private static void printTree(File file, int level) {
        if (file == null || !file.exists()) {
            return;
        }
        printIndent(level);
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    printTree(child, level + 1);
                }
            }
        }
    }
    private static void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
    }
}
