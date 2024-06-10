package dataStructure.Pilha;

public class Pilha {

    private Node top;
    private int height;

    /**
     * Node
     */
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public Pilha(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Pilha vazia");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void print() {
        System.out.println("#########################");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#########################");
    }

    public Node pop() {
        if (height == 0) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;

        return temp;
    }

    public static void main(String[] args) {
        Pilha minhaPilha = new Pilha(2);

        minhaPilha.getTop();
        minhaPilha.getHeight();
        minhaPilha.print();

        minhaPilha.push(1);
        minhaPilha.print();
        minhaPilha.getTop();

        minhaPilha.push(3);
        minhaPilha.print();
        minhaPilha.getTop();

        minhaPilha.pop();
        minhaPilha.print();
        minhaPilha.getTop();

    }
}
