/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Thanh Hang
 */
public class BinarySearchTree {

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    // Hàm insert
    public boolean insert(int value) {
//        Node newNode = new Node(value);

        if (root == null) {
            root = new Node(value);
            return true;
        }
         return insertRecursion(root, value);

//        Node temp = root;
//        while (true) {
//            if (newNode.value < temp.value) {
//                if (temp.left == null) {
//                    temp.left = newNode;
//                    return true;
//                }
//                temp = temp.left;
//            } else if (newNode.value > temp.value) {
//                if (temp.right == null) {
//                    temp.right = newNode;
//                    return true;
//                }
//                temp = temp.right;
//            } else {
//                // Nếu bằng nhau thì bỏ qua (không chèn trùng)
//                return false;
//            }
//        }
    }
    public boolean insertRecursion(Node temp, int value){
        
         if (value == temp.value) {
            return false; // không chèn trùng
        } else if (value < temp.value) {
            if (temp.left == null) {
                temp.left = new Node(value);
                return true;
            }
            return insertRecursion(temp.left, value);
        } else {
            if (temp.right == null) {
                temp.right = new Node(value);
                return true;
            }
            return insertRecursion(temp.right, value);
        }
         
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value == temp.value) {
                return true;
            } else if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }
     public ArrayList<Integer> breadthFirstSearch() {
         
         Node temp = root;
         
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results= new ArrayList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.remove();
            results.add(temp.value);
            System.out.print(temp.value + " ");

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
       return results;
    }
  

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node temp){
                if(temp.left!=null) new Traverse(temp.left);
                results.add(temp.value);
                if(temp.right!=null) new Traverse(temp.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node temp){
                results.add(temp.value);
                if(temp.left!=null) new Traverse(temp.left);
                if(temp.right!=null) new Traverse(temp.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse(Node temp){
               
                if(temp.left!=null) new Traverse(temp.left);
                if(temp.right!=null) new Traverse(temp.right);
                 results.add(temp.value);
            }
        }
         new Traverse(root);
        return results;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree MyBST = new BinarySearchTree(47);
         // Thêm dữ liệu
    MyBST.insert(21);
    MyBST.insert(76);
    MyBST.insert(18);
    MyBST.insert(27);
    MyBST.insert(52);
    MyBST.insert(82);

    // Test contains
    System.out.println("Contains 7? " + MyBST.contains(7));   // true
    System.out.println("Contains 20? " + MyBST.contains(20)); // false

    // BFS
    System.out.println("\nBreadth First Search (BFS): " + MyBST.breadthFirstSearch());

    // DFS Traversals
    System.out.println("In-order: " + MyBST.inOrder());     // [3, 5, 7, 10, 13, 15, 17]
    System.out.println("Pre-order: " + MyBST.preOrder());   // [10, 5, 3, 7, 15, 13, 17]
    System.out.println("Post-order: " + MyBST.postOrder()); // [3, 7, 5, 13, 17, 15, 10]
    }

}
