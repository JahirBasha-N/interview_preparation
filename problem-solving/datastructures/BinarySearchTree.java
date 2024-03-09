package datastructures;

public class BinarySearchTree {
    private Node root;
    public BinarySearchTree() {
        this.root = null;
    }
    static class Node {
        Node leftNode;
        Node rightNode;
        int data;
        public Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.inorder();
        System.out.println();

        bst.search(5);
        bst.search(1);
        bst.search(2);
        bst.search(4);

        bst.delete(3);

        bst.search(4);

        bst.inorder();
    }

    private void inorder() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.leftNode);
            System.out.print(root.data+" ");
            inorder(root.rightNode);
        }
    }

    private void search(int data) {
        search(root, data);
    }

    private void search(Node root, int data) {
        if (root == null) {
            System.out.println("false");
            return;
        }
        if (root.data == data) {
            System.out.println("true");
            return;
        }
        if (data <= root.data) {
            search(root.leftNode, data);
        } else {
            search(root.rightNode, data);
        }
    }

    public void insert(int data) {
        root = insertRecord(root, data);
    }
    private Node insertRecord(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.leftNode = insertRecord(root.leftNode, data);
        } else {
            root.rightNode = insertRecord(root.rightNode, data);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.leftNode = delete(root.leftNode, data);
        } else if (data > root.data) {
            root.rightNode = delete(root.rightNode, data);
        } else {
            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }
            root.data = findMinValue(root.rightNode);
            root.rightNode = delete(root.rightNode, root.data);
        }
        return root;
    }

    private int findMinValue(Node root) {
        return root.leftNode == null ? root.data : findMinValue(root.leftNode);
    }


}
