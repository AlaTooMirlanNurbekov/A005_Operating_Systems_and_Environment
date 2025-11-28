import java.util.Scanner;

/*
 * OS01 - environment variable explorer
 * this program:
 * - asks for the name of an environment variable
 * - reads its value from the operating system
 * - prints the value or a message if it does not exist
 */

public class OS01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("            OS01 - environment           ");
        System.out.println("=========================================");
        System.out.print("enter environment variable name: ");

        String varName = scanner.nextLine().trim();

        if (varName.isEmpty()) {
            System.out.println("invalid input");
            System.out.println("=========================================");
            return;
        }

        /* read environment variable */
        String value = System.getenv(varName);

        if (value == null) {
            System.out.println("variable '" + varName + "' not found");
        } else {
            System.out.println(varName + " = " + value);
        }

        System.out.println("=========================================");
    }
}
