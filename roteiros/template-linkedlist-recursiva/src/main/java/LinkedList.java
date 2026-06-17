import java.util.NoSuchElementException;

public class LinkedList {

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

    public void addFirst(int valor) {
        // cria o novo nó
        Node newNode = new Node(valor);

        // caso esteja vazia: o tail e o head viram o novo nó
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } 
        // caso tenha nós: o head é ligado como next do head, depois o prev do head liga ao newNode, depois o head vira o newNode
        else {
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        // aumenta o tamanho
        this.size++;
    }

    public void addLast(int valor) {
        if (isEmpty()) {
            this.head = new Node(valor);
        } else {
            addLastRecursivo(this.head, valor);
        }
    }

    private void addLastRecursivo(Node atual, int valor) {
        if (atual.next == null) {
            atual.next = new Node(valor);
        } else {
            addLastRecursivo(atual.next, valor);
        }
    }

    /* adiciona um valor na posição passada como parâmetro */
    public void add(int index, int valor) {
        // caso o indice seja invalido lança excessao
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        //cria o novo nó
        Node newNode = new Node(valor);

        if (index == 0) {
            addFirst(valor);
        } else if (index == this.size) {
            addLast(valor);
        } else {
            // aux: inicialmente aponta para head e, a cada passo da iteração, vai sendo atribuída para o próximo da lista
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;

            this.size++;
        }
    }

    public int getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return getFirstRecursivo(this.tail)
        }
    }

    private int getFirstRecursivo(Node atual) {
        if (isEmpty()) {
            return null;
        } else {
            return getFirstRecursivo(atual.prev)
        }
    }

    public int getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return getLastRecursivo(this.head);
        }
    }

    private Node getLastRecursivo(Node atual) {
        if (atual.next == null) {
            return atual;
        } else {
            return getLastRecursivo(atual.next);
        }
    }

    /* retorna o elemento na posição passada como parâmetro deve lançar IndexOutOfBoundsException se o índice não for válido.*/
    public int get(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node elemento = this.head;
        for (int i = 0; i < index; i++) {
            elemento = elemento.next;
        }

        return elemento.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int valor = this.head.value;

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int valor = this.tail.value;

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return valor;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) return removeFirst();
        if (index == size) return removeLast();

        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        this.size--;
        return aux.value;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if (aux.value == value) {
                if (i == 0) removeFirst();
                else if (i == size - 1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    this.size--;
                }
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        int index = 0;

        while (aux != null) {
            if (aux.value == value) return index;
            aux = aux.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int v) {
        return indexOf(v) != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.tail;
        int index = this.size-1;

        while (aux != null) {
            if (aux.value == valor) return index;
            aux = aux.prev;
            index--;
        }

        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }

    public void moveToHead(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        addFirst(remove(index));
    }

    public void insereOrdenado(int v) {
        Node aux = this.tail;
        int indice = this.size;
        while (aux != null && aux.value > v) {
            indice--;
            aux = aux.prev;
        }
        add(indice, v);
    }

    public void swap(Node n1, Node n2) {
        // Caso base: Se forem nulos ou o mesmo nó, não há o que trocar
        if (n1 == null || n2 == null || n1 == n2) {
            return; 
        }

        // Caso 1: n2 está logo após n1
        if (n1.next == n2) {
            swapAdjacent(n1, n2);
            return;
        }

        // Caso 2: n1 está logo após n2
        if (n2.next == n1) {
            swapAdjacent(n2, n1);
            return;
        }

        // Caso 3: Nós não são adjacentes (Caso geral)
        Node prev1 = n1.prev;
        Node next1 = n1.next;
        Node prev2 = n2.prev;
        Node next2 = n2.next;

        // Atualiza os vizinhos de n1 para apontarem para n2
        if (prev1 != null) prev1.next = n2;
        if (next1 != null) next1.prev = n2;

        // Atualiza os vizinhos de n2 para apontarem para n1
        if (prev2 != null) prev2.next = n1;
        if (next2 != null) next2.prev = n1;

        // Troca os ponteiros dos próprios nós (n1 e n2)
        n1.prev = prev2;
        n1.next = next2;
        n2.prev = prev1;
        n2.next = next1;
    }

    private void swapAdjacent(Node left, Node right) {
        Node prevLeft = left.prev;
        Node nextRight = right.next;

        // Ajusta os ponteiros dos próprios nós
        right.prev = prevLeft;
        right.next = left;
        
        left.prev = right;
        left.next = nextRight;

        // Ajusta os vizinhos externos para apontarem para os novos lugares
        if (prevLeft != null) {
            prevLeft.next = right;
        }
        if (nextRight != null) {
            nextRight.prev = left;
        }
    }

    public void inverte() {
        // Caso base: se a lista estiver vazia ou tiver apenas 1 elemento, já está "invertida"
        if (head == null || head == tail) {
            return;
        }

        Node current = this.head;
        Node temp = null;

        // 1. Percorre a lista trocando os ponteiros 'next' e 'prev' de cada nó
        while (current != null) {
            // Troca clássica de duas variáveis usando uma variável temporária
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Como acabámos de inverter os ponteiros, o "próximo" nó original 
            // agora está guardado em 'current.prev'
            current = current.prev;
        }

        // 2. Atualiza as referências globais da lista (head e tail)
        temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }
}

class Node {
    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }
}