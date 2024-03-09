package datastructures;

public class LinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public LinkedList() {
        this.head = null;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//        list.remove(3);
//        System.out.println();
//        list.remove(4);
//        System.out.println();
        list.display();
        list.reverse();
        System.out.println();
        list.display();
        list.reverse();
        System.out.println();
        list.display();
    }

    public void reverse() {
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void remove(int data) {
        Node currentNode = head;
        Node prev;
        if (currentNode.data == data) {
           head = currentNode.next;
           return;
        }
        while (currentNode.next != null) {
            prev = currentNode;
            if (currentNode.next.data == data) {
                System.out.println(data);
                prev.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
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