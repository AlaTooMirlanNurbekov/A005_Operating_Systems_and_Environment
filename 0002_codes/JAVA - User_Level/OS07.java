import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
 * OS07 - system clock and timestamp tool
 * prints the current time in several formats
 * shows how the operating system provides time information
 */

public class OS07 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("            OS07 - system time           ");
        System.out.println("=========================================");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        System.out.println("full timestamp   : " + now.format(f1));
        System.out.println("time only        : " + now.format(f2));
        System.out.println("long date        : " + now.format(f3));
        System.out.println("=========================================");
    }
}
