/*
 * OS30 - Command-line argument parser
 * This code is to show how a process receives arguments from the OS when it starts
 * example: java OS30 --mode=test --count=5 hello
 */

public class OS30 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" OS30 - args viewer ");
        System.out.println("=========================================");

        if (args.length == 0) {
            System.out.println("no arguments given");
            System.out.println("try: java OS30 --mode=test --count=5 hello");
            System.out.println("=========================================");
            return;
        }
        System.out.println("raw arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + ": " + args[i]);
        }
        System.out.println();
        System.out.println("parsed key=value style args:");
        for (String a : args) {
            if (a.startsWith("--") && a.contains("=")) {
                String[] parts = a.substring(2).split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                if (!key.isEmpty()) {
                    System.out.println(key + " = " + value);
                }
            }
        }
        System.out.println("=========================================");
    }
}
