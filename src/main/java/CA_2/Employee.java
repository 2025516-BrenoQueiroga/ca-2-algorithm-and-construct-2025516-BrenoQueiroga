/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author breno
 */
public class Employee {

    private String name;
    private Manager managerType;
    private Department department;

    /**
     * Constructor used to create employee objects
     */
    public Employee(String name, Manager managerType, Department department) {

        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    /**
     * Returns the employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the manager type
     */
    public Manager getManagerType() {
        return managerType;
    }

    /**
     * Returns the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Displays employee information in readable format
     */
    @Override
    public String toString() {

        return "Name: " + name
                + " | Manager: " + managerType
                + " | Department: " + department;
    }
}
