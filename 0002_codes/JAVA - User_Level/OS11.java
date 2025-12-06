import java.io.File;
// OS11 - file type classifier
// counts how many files of each extension exist in a directory

public class OS11 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("          OS11 - file classifier         ");
        System.out.println("=========================================");

        String path = System.getProperty("user.dir");
        File folder = new File(path);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("invalid directory: " + path);
            System.out.println("=========================================");
            return;
        }

        int txt = 0, javaFiles = 0, png = 0, jpg = 0, other = 0;

        File[] files = folder.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    String name = f.getName().toLowerCase();

                    if (name.endsWith(".txt")) {
                        txt++;
                    } else if (name.endsWith(".java")) {
                        javaFiles++;
                    } else if (name.endsWith(".png")) {
                        png++;
                    } else if (name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                        jpg++;
                    } else {
                        other++;
                    }
                }
            }
        }
        System.out.println("txt   : " + txt);
        System.out.println("java  : " + javaFiles);
        System.out.println("png   : " + png);
        System.out.println("jpg   : " + jpg);
        System.out.println("other : " + other);
        System.out.println("=========================================");
    }
}
