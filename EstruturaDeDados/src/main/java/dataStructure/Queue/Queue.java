package dataStructure.Queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void getFirst() {
        if (first != null)
            System.out.println("First: " + first.value);
        else
            System.out.println("Queue vazia");
    }

    public void getLast() {
        if (last != null)
            System.out.println("Last: " + last.value);
        else
            System.out.println("Queue vazia");
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void print() {
        Node temp = first;

        System.out.println("########################################");

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

        System.out.println("########################################");
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode; // vc cria o elemento na ultima posicao
            last = newNode; // vc coloca o apontador nesse elemento
        }

    }

    public Node dequeue() {
        Node temp = first; // elemento a ser removido

        if (length == 0) {
            System.out.println("Fila vazia");
            return null;
        } else if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next; // coloco o apontador para o proximo
            temp.next = null; // aponto o elemento a ser removido para null
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(1);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

        myQueue.enqueue(2);
        myQueue.enqueue(3);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.print();

    }
}
