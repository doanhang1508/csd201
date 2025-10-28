/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hashtable;

import java.util.ArrayList;

/**
 *
 * @author Thanh Hang
 */
public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    class Node {

        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.print(i + ": ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.print("{" + temp.key + "=" + temp.value + "} -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key==key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }
    public ArrayList keys() {
    ArrayList<String> allKeys = new ArrayList<>();
    for (int i = 0; i < dataMap.length; i++) {
        Node temp = dataMap[i];
        while (temp != null) {
            allKeys.add(temp.key);
            temp = temp.next;
        }
    }
    return allKeys;
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("apple", 100);
        ht.set("banana", 200);
        ht.set("orange", 300);
        ht.set("grape", 400);

        System.out.println(ht.get("apple"));
        System.out.println(ht.keys());
        ht.printTable();
    }

}
