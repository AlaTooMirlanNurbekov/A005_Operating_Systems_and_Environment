/*
 * OS16 - config file reader/writer
 * loads simple key=value pairs from a text file
 * allows editing and saving them back
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OS16 {

    public static void main(String[] args) {
        String fileName = "os16_config.txt";
        Map<String, String> config = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("       OS16 - config file manager        ");
        System.out.println("file: " + fileName);
        System.out.println("=========================================");

        /* load existing config if available */
        loadConfig(fileName, config);

        while (true) {
            System.out.println();
            System.out.println("current settings:");
            for (String key : config.keySet()) {
                System.out.println(key + " = " + config.get(key));
            }

            System.out.println();
            System.out.println("options:");
            System.out.println("1 - change a setting");
            System.out.println("2 - save and exit");
            System.out.println("3 - exit without saving");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("enter key: ");
                String key = scanner.nextLine().trim();

                System.out.print("enter value: ");
                String value = scanner.nextLine().trim();

                config.put(key, value);
            }
            else if (choice.equals("2")) {
                saveConfig(fileName, config);
                System.out.println("saved.");
                break;
            }
            else if (choice.equals("3")) {
                System.out.println("no changes saved.");
                break;
            }
        }

        System.out.println("=========================================");
    }

    private static void loadConfig(String fileName, Map<String, String> config) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("=")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    config.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            /* file may not exist yet, ignore */
        }
    }
    private static void saveConfig(String fileName, Map<String, String> config) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String key : config.keySet()) {
                writer.write(key + "=" + config.get(key));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("could not save config file");
        }
    }
}
