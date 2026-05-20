/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 * This class represents one node in the employee tree
 * @author breno
 */
public class TreeNode {

    Employee employee;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor used to create a tree node
     */
    public TreeNode(Employee employee) {

        this.employee = employee;
        this.left = null;
        this.right = null;
    }
}