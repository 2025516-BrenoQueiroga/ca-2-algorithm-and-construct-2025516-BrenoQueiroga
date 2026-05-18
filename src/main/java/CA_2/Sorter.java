/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;

/**
 * This class handles employee sorting operations
 * @author breno
 */
public class Sorter {

    /**
     * Recursive merge sort method
     */
    public static void mergeSort(ArrayList<Employee> employees) {

        // Stop recursion if list size is 1 or smaller
        if (employees.size() <= 1) {
            return;
        }

        int middle = employees.size() / 2;

        ArrayList<Employee> left = new ArrayList<>();
        ArrayList<Employee> right = new ArrayList<>();

        // Split left side
        for (int i = 0; i < middle; i++) {
            left.add(employees.get(i));
        }

        // Split right side
        for (int i = middle; i < employees.size(); i++) {
            right.add(employees.get(i));
        }

        // Recursive calls
        mergeSort(left);
        mergeSort(right);

        // Merge both sides
        merge(employees, left, right);
    }

    /**
     * Merges sorted lists together
     */
    public static void merge(ArrayList<Employee> employees,
                             ArrayList<Employee> left,
                             ArrayList<Employee> right) {

        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = 0;

        // Compare names and merge in alphabetical order
        while (leftIndex < left.size()
                && rightIndex < right.size()) {

            String leftName =
                    left.get(leftIndex).getName();

            String rightName =
                    right.get(rightIndex).getName();

            if (leftName.compareToIgnoreCase(rightName) <= 0) {

                employees.set(mainIndex,
                        left.get(leftIndex));

                leftIndex++;

            } else {

                employees.set(mainIndex,
                        right.get(rightIndex));

                rightIndex++;
            }

            mainIndex++;
        }

        // Add remaining left items
        while (leftIndex < left.size()) {

            employees.set(mainIndex,
                    left.get(leftIndex));

            leftIndex++;
            mainIndex++;
        }

        // Add remaining right items
        while (rightIndex < right.size()) {

            employees.set(mainIndex,
                    right.get(rightIndex));

            rightIndex++;
            mainIndex++;
        }
    }
}
