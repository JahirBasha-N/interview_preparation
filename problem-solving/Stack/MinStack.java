package Stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MinStack {
    Node head;
    static class Node {
        int val;
        Node next;
        int minVal;
        public Node(int val) {
            this.val = val;
        }
    }

    public MinStack() {
       head = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            newNode.minVal = val;
            head = newNode;
            return;
        }
        newNode.minVal = Math.min(val, head.minVal);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
       return head.minVal;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(-1);
        obj.pop();
        System.out.println(obj.top());
        obj.pop();
        obj.push(-2);
        System.out.println(obj.getMin());
    }
}
