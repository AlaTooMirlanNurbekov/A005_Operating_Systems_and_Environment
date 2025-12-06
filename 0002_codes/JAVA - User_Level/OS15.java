//OS15 - simple file logger
// appends timestamped messages to a log file
//demonstrates persistent logging
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OS15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logFile = "os15.log";
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("=========================================");
        System.out.println("            OS15 - file logger           ");
        System.out.println("log file: " + logFile);
        System.out.println("type a message to append");
        System.out.println("type 'exit' to stop");
        System.out.println("=========================================");

        while (true) {
            System.out.print("log> ");
            String msg = scanner.nextLine().trim();
            if (msg.equalsIgnoreCase("exit")) {
                System.out.println("logger stopped");
                break;
            }

            if (msg.isEmpty()) {
                continue;
            }
            String timestamp = LocalDateTime.now().format(formatter);
            String line = timestamp + " - " + msg;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("could not write to log file");
            }
        }
        System.out.println("=========================================");
    }
}
