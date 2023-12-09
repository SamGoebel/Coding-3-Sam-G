package assignment_15_SG;

import java.util.*;

class Node { //node creation
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class Assignment_15 {
    Node root;

    Assignment_15() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) { /*method made to determine where key should be placed 
    									inside binary search tree*/
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) { 
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void delete(int key) { //deleting selected keys
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Assignment_15 bst = new Assignment_15();

        // Task 1: Randomly insert 10 unique numbers from 0 to 9
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums); /* shuffles around values inside "nums" before being 
        							inserted into the binary search table*/
        for (int i = 0; i < 10; i++) {
            bst.insert(nums.get(i));
        }

        System.out.println("Task 1: Final Tree after inserting ten unique numbers");
        bst.inorderTraversal(bst.root);
        System.out.println();

        // Task 2: Delete 3 numbers randomly picked from 0 to 9
        Random rand = new Random();
        HashSet<Integer> deleted = new HashSet<>();
        while (deleted.size() < 3) {//size is three so it does not do more than what was tasked
            int deleteNum = rand.nextInt(10);
            if (!deleted.contains(deleteNum)) {
                deleted.add(deleteNum);
                bst.delete(deleteNum);
            }
        }

        System.out.println("\nTask 2: Final Tree after deleting three random numbers");
        bst.inorderTraversal(bst.root);
        System.out.println();

        // Task 3: Search 3 numbers from 0 to 9 randomly 
        System.out.println("\nTask 3: Search three different numbers from 0 to 9 randomly ");
        HashSet<Integer> searched = new HashSet<>();
        while (searched.size() < 3) { //size is three so it does not do more than what was tasked
            int searchNum = rand.nextInt(10);
            if (!searched.contains(searchNum)) {
                searched.add(searchNum);
                boolean found = bst.search(searchNum);
                if (found) {
                    System.out.println("Key " + searchNum + " found in the tree");
                } else {
                    System.out.println("Key " + searchNum + " not found in the tree");
                }
            }
        }
    }
}
