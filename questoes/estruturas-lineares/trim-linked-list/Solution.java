import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        LinkedList ll = new LinkedList();
        for (int i = 0; i < seq.length; i++) {
            ll.addLast(Integer.parseInt(seq[i]));
        }

        int qtd = sc.nextInt();

        while (qtd > 0) {
            ll.removeFirst();
            ll.removeLast();
            qtd--;
        }
        
        System.out.println(ll.toString());
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void removeFirst() {
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
    }

    public void removeLast() {
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public String toString() {
        if (isEmpty()) return "vazia";

        String out = "";
        Node aux = this.head;
        while (aux != null) {
            out += aux.valor + " ";
            aux = aux.next;
        }
        return out.trim();
    }
}

class Node {
    Node next;
    Node prev;
    int valor;

    public Node(int valor) {
        this.next = null;
        this.prev = null;
        this.valor = valor;
    }
}