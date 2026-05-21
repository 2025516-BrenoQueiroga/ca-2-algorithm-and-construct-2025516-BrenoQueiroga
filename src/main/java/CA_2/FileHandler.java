/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author breno
 */
public class FileHandler {

    /**
     * This class handles file reading operations
     * Reads employee records from a text file
     */
    public static ArrayList<Employee> readFile(String fileName) {

        // List used to store employees
        ArrayList<Employee> employees = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            // Skip header line
            reader.readLine();

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                // Skip empty or incomplete lines
                if (data.length < 9) {
                    continue;
                }

                String firstName = data[0];
                String lastName = data[1];

                String fullName = firstName + " " + lastName;

                String departmentText = data[5].toUpperCase().replace(" ", "_");

                Department department;

                // Convert department safely
                try {
                    department = Department.valueOf(departmentText);
                } catch (IllegalArgumentException e) {
                    department = Department.IT;
                }

                Manager manager;

                // Assign manager type based on job title
                String position = data[6].toLowerCase();
                String jobTitle = data[7].toLowerCase();

                if (jobTitle.contains("senior manager") || position.contains("senior")) {
                    manager = Manager.HEAD_MANAGER;

                } else if (jobTitle.contains("manager") || position.contains("middle")) {
                    manager = Manager.ASSISTANT_MANAGER;

                } else {
                    manager = Manager.TEAM_LEAD;
                }

                // Create employee object
                Employee employee = new Employee(
                        fullName,
                        manager,
                        department
                );

                employees.add(employee);
            }

            reader.close();

            System.out.println("File read successfully");

        } catch (IOException e) {

            System.out.println("Error reading file");
        }

        return employees;
    }
}