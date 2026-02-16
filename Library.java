import java.util.*;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting system");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        books.add(new Book(id, title));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.display();
        }
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getBookId() == id) {
                book.issueBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getBookId() == id) {
                book.returnBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }
}
