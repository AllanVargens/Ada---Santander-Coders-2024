package dataStructure.LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        String data;
        Node next; // apontador para o prox no

        public Node(String data) {
            this.data = data;
        }
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getTail() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Tail: " + tail.data);

        }
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void print() {
        System.out.println("##################################");
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("##################################");

    }

    public Node get(int index) {
        if (index < 0 || index >= this.length)
            return null;
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(String data) { // add no inicio da lista
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public boolean insert(int index, String data) {
        if (index < 0 || index > this.length)
            return false;
        if (index == 0) {
            prepend(data);
            return true;
        } else if (index == length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node tempo = get(index - 1);
        newNode.next = tempo.next;
        tempo.next = newNode;
        length++;
        return true;

    }

    public boolean set(int index, String data) {
        Node temp = get(index);
        if (temp == null)
            return false;
        temp.data = data;
        return true;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node pre = head;
        Node temp = null;

        while (pre.next != tail) {
            pre = pre.next;
        }
        temp = tail;
        tail = pre;
        tail.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("elemento 1");
        list.append("elemento 2");
        list.append("elemento 3");

        list.getHead();
        list.getTail();
        list.getLength();
        list.print();
        list.set(1, "elemento 4");
        list.print();

    }
}
