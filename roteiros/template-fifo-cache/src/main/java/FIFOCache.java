import java.util.*;

public class FIFOCache {

    private int head;
    private int tail;
    private int size;
    private String[] fila;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.fila = new String[capacidade];
    }

    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return this.size >= this.fila.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        if (isFull()) {
            this.head = (this.head + 1) % this.fila.length;
        } else {
            this.size++;
        }

        if (this.head == -1) {
            this.head = 0;
        }

        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[this.tail] = chave;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        String valor = this.fila[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }

        this.size--;
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem remover;
    public String getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.fila[head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.fila[tail];
    }

    public String get(String valor) {
        int indice = this.head;
        for (int i = 0; i < this.size; i++) {
            if (this.fila[indice].equals(valor)) return this.fila[indice];
            indice = (indice + 1) % this.fila.length;
        }
        return null;
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        if (isEmpty()) return "";

        String out = "[";
        for (int i = 0; i < this.size; i++) {
            if (i == this.tail) out += this.fila[i];
            else out += this.fila[i] + ", ";
        }
        return out.trim() + "]";
    }
    
    public int size() {
        return this.size;
    }
}
