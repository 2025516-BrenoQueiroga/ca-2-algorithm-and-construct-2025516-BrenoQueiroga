/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;

/**
 * This class handles employee searching operations
 * @author breno
 */
public class Searcher {

    /**
     * Recursive binary search method
     */
    public static Employee binarySearch(ArrayList<Employee> employees,
                                        String target,
                                        int left,
                                        int right) {

        // Stop search if employee is not found
        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;

        String middleName =
                employees.get(middle).getName();

        int comparison =
                target.compareToIgnoreCase(middleName);

        // Employee found
        if (comparison == 0) {

            return employees.get(middle);

        // Continue search on left side
        } else if (comparison < 0) {

            return binarySearch(
                    employees,
                    target,
                    left,
                    middle - 1
            );

        // Continue search on right side
        } else {

            return binarySearch(
                    employees,
                    target,
                    middle + 1,
                    right
            );
        }
    }
}