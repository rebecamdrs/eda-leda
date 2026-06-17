public class LRUCache {

    private LinkedList ll;
    private int capacidade;

    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LRUCache(int capacidade) {
        this.ll = new LinkedList();
        this.capacidade = capacidade;
    }

    public boolean isEmpty() {
        return this.ll.isEmpty();
    }

    public boolean isFull() {
        return this.ll.size() >= this.capacidade;
    }

    // deve ser O(1)
    public void addLast(String chave) {
        if (isFull()) this.ll.removeFirst();
        this.ll.addLast(chave);
    }

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Encontrando ou não, o elemento deve ser movido para o final da lista
    public String get(String value) {
        Node node = this.ll.get(value);
        if (node != null) {
            this.ll.moveToTail(node);
            return node.value;
        } 
        return null;
    }

    // O(1)
    public String getFirst() {
        return this.ll.getFirst();
    }

    // O(1)
    public String getLast() {
        return this.ll.getLast();
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        return this.ll.toString();
    }
    
    public int size() {
        return this.ll.size();
    }
}
