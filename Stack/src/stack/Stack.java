/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack;

/**
 *
 * @author Thanh Hang
 */
public class Stack {

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int hight;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        hight = 1;
    }

    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getTop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // hoặc ném exception tuỳ yêu cầu
        }
        return top.value;
    }

    public int getHight() {
        return hight;
    }
    
    public void push(int value) {
        Node newNode = new Node(value);
        if (hight==0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        hight++;
    }
    
    public Node pop(){
        Node temp = top;
        if (hight == 0) {
            return null;
        } else {
            top = top.next;
            temp.next = null;
        }
        hight--;
        return temp;
    }
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack myStack = new Stack(2);
        
        myStack.push(3);
        
        myStack.pop();
        
        myStack.printStack();
    }

}
