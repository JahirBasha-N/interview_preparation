package datastructures;

import java.util.LinkedList;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);

        dll.reverse();
        dll.display();

    }

    private void reverse() {
        Node currentNode = head;
        Node tempNode = null;
        while (currentNode != null) {
            tempNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = tempNode;
            currentNode = currentNode.prev;
        }
        head = tempNode.prev;
    }

    private void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    private void display() {
        Node currentNode = head;
        while (currentNode.next != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.data);
    }

}
