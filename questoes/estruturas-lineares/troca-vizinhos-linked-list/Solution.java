import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] lista = new int[seq.length];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = Integer.parseInt(seq[i]);
        }
        int indice = sc.nextInt();
        trocaVizinhos(lista, indice);
    }

    public static void trocaVizinhos(int[] v, int indice) {
        LinkedList ll = new LinkedList();
        for (int elem : v) {
            ll.addLast(elem);
        }

        int no1 = ll.remove(indice);
        ll.add(indice+1, no1);
        
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

    public void addFirst(int valor) {
        Node newNode = new Node(valor);
            
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
            
        this.size += 1;
    }

    public void add(int index, int valor) {
        Node newNode = new Node(valor);

        if (index == 0) addFirst(valor);
        else if (index == this.size) addLast(valor);
        else {
            Node aux = this.head;
            for (int i = 0; i < index-1; i++) {
                aux = aux.next;
            }
            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;

            this.size++;
        }
    }

    public int removeFirst() {
        int aux = this.head.valor;
        
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return aux;
    }

    public int removeLast() {
        int aux = this.tail.valor;
        
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return aux;
    }

    public int remove(int index) {
        if (index == 0) return removeFirst();
        else if (index == size-1) return removeLast();

        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        
        this.size--;
        return aux.valor;
    }

    public String toString() {
        String out = "";
        Node aux = this.head;

        while(aux != null) {
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