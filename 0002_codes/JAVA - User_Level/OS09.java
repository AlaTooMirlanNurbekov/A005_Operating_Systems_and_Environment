import java.io.File;
/* OS09 - disk space viewer
 * Shows total, free, and used disk space helps understand storage as an operating system resource */

public class OS09 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("            OS09 - disk space            ");
        System.out.println("=========================================");

        File root = new File("/");

        long total = root.getTotalSpace();
        long free  = root.getFreeSpace();
        long usable = root.getUsableSpace();
        long used = total - free;

        System.out.println("total space  : " + format(total));
        System.out.println("used space   : " + format(used));
        System.out.println("free space   : " + format(free));
        System.out.println("usable space : " + format(usable));
        System.out.println("=========================================");
    }
    private static String format(long bytes) {
        long mb = bytes / (1024 * 1024);
        return mb + " MB";
    }
}
