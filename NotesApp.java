import java.util.*;
import java.io.*;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println(" NOTES APP ");
            System.out.println("1. Write Note (Overwrite)");
            System.out.println("2. Append Note");
            System.out.println("3. Read Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    writeNote(false);
                    break;
                case 2:
                    writeNote(true);
                    break;
                case 3:
                    readNotes();
                    break;
                case 4:
                    System.out.println("Exiting Notes App");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Write or Append Note
    private static void writeNote(boolean appendMode) {

        System.out.println("Enter your note:");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, appendMode)) {

            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    // Read Notes
    private static void readNotes() {

        try (FileReader fileReader = new FileReader(FILE_NAME);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            System.out.println(" Your Notes: ");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file (file may not exist yet).");
            e.printStackTrace();
        }
    }
}
