/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.Scanner;
import java.util.ArrayList;
        
/**
 * Main class for the Bank Organisation System
 * @author breno
 */
public class Main {

    // Scanner used to read user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Read employee data from file
        ArrayList<Employee> employees =
                FileHandler.readFile("Applicants_Form.txt");

        int choice;

        do {

            showMenu();

            // Read user menu option
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("SORT selected");

                    // Sort employees alphabetically
                    Sorter.mergeSort(employees);

                    // Show only the first twenty employees
                    displayFirstTwentyEmployees(employees);
                    break;

                case 2:
                    System.out.println("SEARCH selected");

                    // Sort list before searching
                    Sorter.mergeSort(employees);

                    // Read employee name
                    System.out.print("Enter employee name: ");
                    String target = scanner.nextLine();

                    // Search employee
                    Employee foundEmployee =
                            Searcher.binarySearch(
                                    employees,
                                    target,
                                    0,
                                    employees.size() - 1
                            );

                    // Show result
                    if (foundEmployee != null) {

                        System.out.println("Employee found:");
                        System.out.println(foundEmployee);

                    } else {

                        System.out.println("Employee not found");
                    }

                    break;

                case 3:
                    System.out.println("ADD RECORD selected");

                    Employee newEmployee = addNewEmployee();

                    if (newEmployee != null) {
                        employees.add(newEmployee);
                        System.out.println("Employee added successfully:");
                        System.out.println(newEmployee);
                    }

                    break;

                case 4:
                    System.out.println("CREATE BINARY TREE selected");

                    EmployeeTree tree = new EmployeeTree();

                    for (int i = 0; i < 20 && i < employees.size(); i++) {
                        tree.insert(employees.get(i));
                    }

                    tree.displayLevelOrder();

                    System.out.println("\nTotal nodes: "
                            + tree.countNodes());

                    System.out.println("Tree height: "
                            + tree.getHeight());

                    break;

                case 5:
                    System.out.println("Program terminated");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (choice != 5);
    }

    /**
     * Displays all menu options using Enum values
     */
    public static void showMenu() {

        System.out.println("\n=== BANK ORGANISATION SYSTEM ===");

        int index = 1;

        // Loop through all enum values
        for (MenuOption option : MenuOption.values()) {

            System.out.println(index + ". " + option);
            index++;
        }
    }
     /**
     * Displays the first twenty employees after sorting
     */
    public static void displayFirstTwentyEmployees(ArrayList<Employee> employees) {

        // Check if there are no employees loaded
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }

        int limit = 20;

        // Avoid error if the list has less than twenty employees
        if (employees.size() < limit) {
            limit = employees.size();
        }

        System.out.println("\nFirst " + limit + " employees in alphabetical order:");

        for (int i = 0; i < limit; i++) {
            System.out.println(employees.get(i));
        }
    }
    /**
    * Reads user input and creates a new employee
    */
    public static Employee addNewEmployee() {

        // Read employee name
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Employee name cannot be empty");
            return null;
        }

        // Show manager options
        System.out.println("Select manager type:");
        System.out.println("1. Head Manager");
        System.out.println("2. Assistant Manager");
        System.out.println("3. Team Lead");

        System.out.print("Enter your choice: ");
        int managerChoice = scanner.nextInt();
        scanner.nextLine();

        Manager managerType;

        if (managerChoice == 1) {
            managerType = Manager.HEAD_MANAGER;

        } else if (managerChoice == 2) {
            managerType = Manager.ASSISTANT_MANAGER;

        } else if (managerChoice == 3) {
            managerType = Manager.TEAM_LEAD;

        } else {
            System.out.println("Invalid manager choice");
            return null;
        }

        // Show department options
        System.out.println("Select department:");
        System.out.println("1. Customer Service");
        System.out.println("2. Foreign Exchange");
        System.out.println("3. HR");
        System.out.println("4. Finance");
        System.out.println("5. IT");

        System.out.print("Enter your choice: ");
        int departmentChoice = scanner.nextInt();
        scanner.nextLine();

        Department department;

        if (departmentChoice == 1) {
            department = Department.CUSTOMER_SERVICE;

        } else if (departmentChoice == 2) {
            department = Department.FOREIGN_EXCHANGE;

        } else if (departmentChoice == 3) {
            department = Department.HR;

        } else if (departmentChoice == 4) {
            department = Department.FINANCE;

        } else if (departmentChoice == 5) {
            department = Department.IT;

        } else {
            System.out.println("Invalid department choice");
            return null;
        }

        return new Employee(name, managerType, department);
    }
 }