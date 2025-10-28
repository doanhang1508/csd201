/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queues;

/**
 *
 * @author Thanh Hang
 */
public class Queues {

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public Queues(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        if (first == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode; // nối node mới vào sau cùng
            last = newNode;      // cập nhật lại last
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0) {
            return null;
        }

        Node temp = first;

        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;  // dịch first sang node tiếp theo
            temp.next = null;    // ngắt liên kết node cũ
        }

        length--;
        return temp; // trả về Node vừa bị lấy ra
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queues myQueue = new Queues(2);

        myQueue.enqueue(3);

        myQueue.dequeue();

        myQueue.printQueue();
    }

}
