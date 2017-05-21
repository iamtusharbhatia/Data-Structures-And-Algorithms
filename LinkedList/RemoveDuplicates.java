package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tushar on 5/20/2017.
 */
public class RemoveDuplicates {

    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    //This method removes duplicates from a linked list in a single pass
    static void removeDup(){

        if(head == null){
            System.out.println("Linked List is empty");
        } else {
            Set<Integer> mySet = new HashSet<>();
            mySet.add(head.data);
            Node traverse = head;
            while(traverse.next != null){
                if(!mySet.contains(traverse.next.data)) {
                    mySet.add(traverse.next.data);
                    traverse = traverse.next;
                } else {
                    traverse.next = traverse.next.next;
                }
            }
        }

    }

    //Method to print the linked list
    static void printll(){

        if(head == null){
            System.out.println("Linked List is empty");
        } else {
            Node traverse = head;
            while(traverse != null){
                System.out.print(traverse.data + " ");
                traverse = traverse.next;
            }
        }

    }

    public static void main(String args[]){

        RemoveDuplicates obj = new RemoveDuplicates();
        obj.head = new Node(10);

        Node n1 = new Node(20);
        Node n2 = new Node(30);
        Node n3 = new Node(40);
        Node n4 = new Node(50);
        Node n5 = new Node(30);
        Node n6 = new Node(50);

        obj.head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        printll();
        removeDup();
        System.out.println("\nList without duplicates");
        printll();
    }
}
