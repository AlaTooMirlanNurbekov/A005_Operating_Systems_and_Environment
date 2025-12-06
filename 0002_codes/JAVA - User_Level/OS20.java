// OS20 - process info viewer
// Shows basic information about the running java process such as pid, uptime, and command-line arguments
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class OS20 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("          OS20 - process viewer          ");
        System.out.println("=========================================");
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
        /* get pid (part before '@' in runtime name) */
        String name = runtime.getName();  
        String pid = name.split("@")[0];
        System.out.println("process id      : " + pid);
        System.out.println("jvm name        : " + name);
        System.out.println("uptime (ms)     : " + runtime.getUptime());
        System.out.println("start time (ms) : " + runtime.getStartTime());
        System.out.println();

        System.out.println("command-line arguments:");
        if (args.length == 0) {
            System.out.println("(none)");
        } else {
            for (String a : args) {
                System.out.println("- " + a);
            }
        }
        System.out.println("=========================================");
    }
}
