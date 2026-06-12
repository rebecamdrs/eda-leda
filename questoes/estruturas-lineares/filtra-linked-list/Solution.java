import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        LinkedList ll = new LinkedList();
        for (int i = 0; i < seq.length; i++) {
            ll.addLast(Integer.parseInt(seq[i]));
        }

        int elemento = sc.nextInt();
        ll.removeIguais(elemento);
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

    public void remove(int valor) {
        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if (aux.valor == valor) {
                if (i == 0) removeFirst();
                else if (i == this.size-1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    this.size--;
                }
                return;
            }
            aux = aux.next;
        }
    }

    public void removeIguais(int valor) {
        Node aux = this.head;
        while (aux != null) {
            if (aux.valor == valor) {
                remove(valor);
                aux = this.head; // reinicia a busca
            } else {
                aux = aux.next;
            }
        }
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

    public Node (int valor) {
        this.next = null;
        this.prev = null;
        this.valor = valor;
    }
}