/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doublelinkedlist;

/**
 *
 * @author Thanh Hang
 */
public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {

        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor
    public DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Hiển thị danh sách
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp;
        // Tối ưu: nếu index ở nửa đầu thì duyệt từ head, nửa cuối thì duyệt từ tail
        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }
    
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;
    }
    
     public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }
     
     public int size() {
        return length;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tạo danh sách liên kết đôi rỗng
        DoubleLinkedList dll = new DoubleLinkedList(1);

        // Thêm phần tử vào cuối
        dll.append(10);
        dll.append(20);
        dll.append(30);
        System.out.print("Sau khi append: ");
        dll.printList(); // 10 20 30

        // Thêm phần tử vào đầu
        dll.prepend(5);
        System.out.print("Sau khi prepend: ");
        dll.printList(); // 5 10 20 30

        // Lấy node tại index
        System.out.println("Node tại index 2: " + dll.get(2).value); // 20

        // Đặt lại giá trị
        dll.set(2, 99);
        System.out.print("Sau khi set index 2 = 99: ");
        dll.printList(); // 5 10 99 30

        // Chèn vào giữa
        dll.insert(2, 15);
        System.out.print("Sau khi insert 15 tại index 2: ");
        dll.printList(); // 5 10 15 99 30

        // Xoá phần tử đầu
        dll.removeFirst();
        System.out.print("Sau khi removeFirst: ");
        dll.printList(); // 10 15 99 30

        // Xoá phần tử cuối
        dll.removeLast();
        System.out.print("Sau khi removeLast: ");
        dll.printList(); // 10 15 99

        // Xoá phần tử giữa
        dll.remove(1);
        System.out.print("Sau khi remove index 1: ");
        dll.printList(); // 10 99

        // In độ dài
        System.out.println("Độ dài danh sách: " + dll.size());

    }

}
