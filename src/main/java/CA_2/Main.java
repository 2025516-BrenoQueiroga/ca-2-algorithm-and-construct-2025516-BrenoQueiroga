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
                    break;

                case 3:
                    System.out.println("ADD RECORD selected");
                    break;

                case 4:
                    System.out.println("CREATE BINARY TREE selected");
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
}