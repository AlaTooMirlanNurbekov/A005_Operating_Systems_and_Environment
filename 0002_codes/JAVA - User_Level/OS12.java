import java.util.Scanner;
// OS12 - simple login simulator (a basic login check using username and password)
// simple authentication idea

public class OS12 {

    public static void main(String[] args) {
        final String correctUser = "student";
        final String correctPass = "ose123";

        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = 3;
        boolean loggedIn = false;
        System.out.println("=========================================");
        System.out.println("            OS12 - login demo            ");
        System.out.println("=========================================");

        while (attemptsLeft > 0 && !loggedIn) {
            System.out.print("username: ");
            String user = scanner.nextLine().trim();
            System.out.print("password: ");
            String pass = scanner.nextLine().trim();

            if (user.equals(correctUser) && pass.equals(correctPass)) {
                loggedIn = true;
            } else {
                attemptsLeft--;
                System.out.println("login failed. attempts left: " + attemptsLeft);
                System.out.println();
            }
        }

        if (loggedIn) {
            System.out.println("login successful. welcome, " + correctUser + "!");
        } else {
            System.out.println("too many failed attempts. access denied.");
        }
        System.out.println("=========================================");
    }
}
