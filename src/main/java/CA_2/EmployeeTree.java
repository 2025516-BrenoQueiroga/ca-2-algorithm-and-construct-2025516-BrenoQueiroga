/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author breno
 */
public class EmployeeTree {

    private TreeNode root;

    /**
     * Constructor starts the tree as empty
     */
    public EmployeeTree() {

        root = null;
    }

    /**
     * Inserts employees using level order
     */
    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);

        // First employee becomes the root
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.remove();

            // Fill left child first
            if (current.left == null) {
                current.left = newNode;
                return;

            } else {
                queue.add(current.left);
            }

            // Fill right child after left
            if (current.right == null) {
                current.right = newNode;
                return;

            } else {
                queue.add(current.right);
            }
        }
    }
}