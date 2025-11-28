import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * OS00 - system welcome inf
 * this program prints:
 * - operating system name
 * - cpu architecture
 * - current user name
 * - current date and time
 */

public class OS00 {

    public static void main(String[] args) {
        /* get os name from system properties */
        String osName = System.getProperty("os.name", "unknown os");

        /* get architecture, try to map to 32 or 64 bit */
        String arch = System.getProperty("os.arch", "unknown");
        String bits;

        if (arch.contains("64")) {
            bits = "64";
        } else if (arch.contains("32") || arch.equalsIgnoreCase("x86")) {
            bits = "32";
        } else {
            bits = "?";
        }

        /* get user name */
        String user = System.getProperty("user.name", "unknown user");

        /* get current date and time */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = now.format(formatter);

        /* print info */
        System.out.println("=========================================");
        System.out.println("               OS00 - info               ");
        System.out.println("=========================================");
        System.out.println("operating system : " + osName);
        System.out.println("architecture     : " + bits + "-bit (" + arch + ")");
        System.out.println("current user     : " + user);
        System.out.println("current date/time: " + timeStr);
        System.out.println("=========================================");
    }
}
