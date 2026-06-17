import java.util.*;

public class Fila {

    private int[] fila;
    private int inicio;
    private int fim;
    private int tamanho;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.inicio = -1;
        this.fim = -1;
        this.tamanho = 0;
    }


    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public boolean isFull() {
        return this.tamanho >= this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) {
            throw new IllegalStateException("A capacidade máxima da fila foi atingida.");
        }

        if (isEmpty()) {
            this.inicio = 0;
        }

        // atualiza do fim
        this.fim = (this.fim + 1) % this.fila.length;

        // adiciona na fila e incrementa o tamanho
        this.fila[this.fim] = valor;
        this.tamanho += 1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // recupera o elemento no início da fila
        int elementoInicio = this.fila[this.inicio];

        if (this.inicio == this.fim) {
            this.inicio = -1;
            this.fim = -1;
        } else {
            this.inicio = (this.inicio + 1) % this.fila.length;
        }

        this.tamanho -= 1;
        return elementoInicio;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.fila[this.inicio];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.fila[this.fim];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String out = "";
        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.fila.length;

            if (i == this.tamanho - 1) out += this.fila[pos];
            else out += this.fila[pos] + ", ";
        }
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.fila.length;

            if (this.fila[pos] == valor) return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        for (int i = this.tamanho - 1; i >= 0; i--) {
            int pos = (this.inicio + i) % this.fila.length;

            if (this.fila[pos] == valor) return i;
        }
        return -1;
    }

    public int size() {
        return tamanho;
    }
}