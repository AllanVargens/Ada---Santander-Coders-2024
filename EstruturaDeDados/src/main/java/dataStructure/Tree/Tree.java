package dataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Node root;

    /**
     * Node
     */
    public class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                Node currentNode = queue.remove();
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() { // RAIZ - ESQUERDA - DIREITA
        preOrder(root);
    }

    private void preOrder(final Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() { // ESQUERDA - RAIZ - DIREITA
        inOrder(root);
    }

    private void inOrder(final Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder() { // ESQUERDA - DIREITA - RAIZ
        posOrder(root);
    }

    private void posOrder(final Node node) {
        if (node == null)
            return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    public void BFS(){
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.left !=null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
    }

    
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(37);
        tree.insert(12);
        tree.insert(45);
        tree.insert(56);
        tree.insert(60);
        tree.insert(32);
        tree.insert(15);
        System.out.println(tree.root.value);
        System.out.println(tree.root.left.value);
        System.out.println(tree.root.right.value);

    }

}
