import java.util.ArrayList;
import java.util.Scanner;

class Staff {
    private String name;
    private String position;
    private double salary;

    public Staff(String name, String position) {
        this.name = name;
        this.position = position;
        this.salary = 0; // Initialize salary to 0
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPosition: " + position + "\nSalary: $" + salary;
    }
}

public class SchoolSystem {
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nSchool System Menu:");
            System.out.println("1. Employ Staff");
            System.out.println("2. Allocate Salary");
            System.out.println("3. View Staff Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    employStaff();
                    break;
                case 2:
                    allocateSalary();
                    break;
                case 3:
                    viewStaffInformation();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void employStaff() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff position: ");
        String position = scanner.nextLine();

        Staff newStaff = new Staff(name, position);
        staffList.add(newStaff);

        System.out.println("Staff employed successfully.");
    }

    private static void allocateSalary() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter salary amount: $");
        double salary = scanner.nextDouble();

        boolean staffFound = false;
        for (Staff staff : staffList) {
            if (staff.getName().equalsIgnoreCase(name)) {
                staff.setSalary(salary);
                staffFound = true;
                System.out.println("Salary allocated successfully.");
                break;
            }
        }

        if (!staffFound) {
            System.out.println("Staff not found.");
        }
    }

    private static void viewStaffInformation() {
        System.out.println("\nStaff Information:");
        for (Staff staff : staffList) {
            System.out.println("\n" + staff);
        }
    }
}
