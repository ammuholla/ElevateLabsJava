import java.util.*;

public class StudentManagementSystem {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Student> students= new ArrayList<>();

    public static void addStudent(){
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    public static void viewStudents(){
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.display();
        }
    }

    public static void updateStudent(){
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getId() == id) {

                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();

                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();

                student.setName(newName);
                student.setMarks(newMarks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent(){
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void main(String[] args){
        int choice;
        do {
            System.out.println("\n STUDENT RECORD MANAGEMENT SYSTEM ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
          
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
        scanner.close();
    }
}
