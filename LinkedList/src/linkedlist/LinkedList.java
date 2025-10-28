/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author Thanh Hang
 */
public class LinkedList {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    private Node head; 
    private Node tail;
    private int length;
    
    private LinkedList(int value){
        Node newNode= new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    
    public void printList() {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.value + " -> ");
        temp = temp.next;
        }
    System.out.println("null");
    }
    
    public void append(int value){
        Node newNode= new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next=newNode;
             tail = newNode;   
        }
        length++;
    }
    
    public void preAppend(int value){
        Node newNode = new Node(value);
       
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head= newNode;
        }
        length++;
    }
    
    public Node removeLast(){
        Node temp=head;
        Node pre=head;
        if(length==0) return null;
        else{
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        }
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }
    public Node removeFirst(){
        Node temp=head;
        if(length==0) return null;
        else{
            head=head.next;
            temp.next=null;
        }
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }
    
    public Node get(int index){
        if(index<0 || index >= length) return null;
        Node temp = head;
        for(int i=0; i<index; i++){
            temp= temp.next;
        }
        return temp;
    }
    
    public boolean set(int index, int value){
        if (index < 0 || index >= length) return false;
        
        Node temp= get(index);
        
        if(temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }
    
    public boolean insert(int index, int value){
         if (index < 0 || index > length) return false;
         Node newNode = new Node(value);
         if(index==0){
             preAppend(value);
             return true;
         }
         if(index==length){
             append(value);
             return true;
         }
         
//         Node prev = get(index-1);
//newNode.next = prev.next;
//prev.next = newNode;
         Node temp = get(index-1);
         Node temp1= get(index);
         
         temp.next= newNode;
         newNode.next=temp1;
         length++;
         return true;
    }
    
    public Node remove(int index){
          if (index < 0 || index >= length) return null;
          Node removeNode;
          if(index==0){
              return removeFirst();
          }
          if(index==length-1){
              return removeLast();
          }
          Node temp = get(index-1);
          removeNode=temp.next;
          temp.next=removeNode.next;
          removeNode.next=null;
          length--;
          return removeNode;
    }
    
    
    
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1); 
        myList.append(2);
        myList.removeLast();
        System.out.println(myList.get(2)+"\n");
        myList.set(1, 4);
        myList.printList();
    }
    
}
