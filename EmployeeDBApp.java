import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";       // change if needed
    private static final String PASSWORD = "root";   // change if needed

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE DATABASE APP =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }

    // Add Employee
    private static void addEmployee(Scanner scanner) {
        String sql = "INSERT INTO employees (name, salary, department) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            scanner.nextLine();
            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, dept);

            ps.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //View Employees
    private static void viewEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Employee List ---");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary") +
                        ", Dept: " + rs.getString("department")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    private static void updateEmployee(Scanner scanner) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = scanner.nextDouble();

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delete Employee
    private static void deleteEmployee(Scanner scanner) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Enter Employee ID to delete: ");
            int id = scanner.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
