//OS08 - user session info viewer
//prints information about the current user session uses system properties provided by the operating system

public class OS08 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("           OS08 - user session           ");
        System.out.println("=========================================");
        String user = System.getProperty("user.name", "unknown");
        String home = System.getProperty("user.home", "unknown");
        String dir = System.getProperty("user.dir", "unknown");
        System.out.println("current user : " + user);
        System.out.println("home folder  : " + home);
        System.out.println("working dir  : " + dir);
        System.out.println("=========================================");
    }
}
