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

    /**
     * Displays the tree using level order traversal
     */
    public void displayLevelOrder() {

        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            System.out.println("\nLevel " + level + ":");

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.remove();

                System.out.println(current.employee);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            level++;
        }
    }
    /**
    * Returns the total number of nodes in the tree
    */
    public int countNodes() {

        return countNodesRecursive(root);
    }

    /**
     * Recursive method used to count nodes
     */
    private int countNodesRecursive(TreeNode node) {

        // Stop recursion if node is empty
        if (node == null) {
            return 0;
        }

        return 1
                + countNodesRecursive(node.left)
                + countNodesRecursive(node.right);
    }

    /**
     * Returns the height of the tree
     */
    public int getHeight() {

        return getHeightRecursive(root);
    }

    /**
     * Recursive method used to calculate tree height
     */
    private int getHeightRecursive(TreeNode node) {

        // Stop recursion if node is empty
        if (node == null) {
            return 0;
        }

        int leftHeight =
                getHeightRecursive(node.left);

        int rightHeight =
                getHeightRecursive(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}