package datastructures;

public class Queue {
    private Node front, rear;
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        queue.display();
        System.out.println();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println();
        queue.display();
    }
    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public void deQueue() {
        System.out.println("front element deleted " + front.data);
        front = front.next;
    }
    public void display() {
        Node currentNode = front;
        while (currentNode.next != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}
