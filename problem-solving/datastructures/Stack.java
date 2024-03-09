package datastructures;

public class Stack {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top;
    public Stack() {
        this.top = null;
    }
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.display();
        System.out.println("peek " + stack.peek());
        stack.pop();
        stack.display();
    }

    private void display() {
        Node currentNode = top;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    private void pop() {
        System.out.println("popped " + top.data);
        top = top.next;
        System.out.println("current top " + top.data);
    }

    private int peek() {
        return top.data;
    }
}
