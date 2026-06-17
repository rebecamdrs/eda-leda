public class ArrayList {

    private int[] lista;
    private int tamanho;

    public ArrayList(int capacidadeInicial) {
        this.lista = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void addFirst(int valor) {
        assegureCapacidade(this.tamanho + 1);
        shiftDireita(0);
        this.lista[0] = valor;
        this.tamanho += 1;
    }

    public void addLast(int valor) {
        assegureCapacidade(this.tamanho + 1);
        this.lista[this.tamanho] = valor;
        this.tamanho += 1;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > this.tamanho) {
            throw new IndexOutOfBoundsException();
        }

        assegureCapacidade(this.tamanho + 1);
        shiftDireita(index);

        this.lista[index] = valor;
        this.tamanho += 1;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
        int[] novaLista = new int[novaCapacidade];
        for (int i = 0; i < this.lista.length; i++) {
            novaLista[i] = this.lista[i];
        }
        this.lista = novaLista;
    }

    public void assegureCapacidade(int capacidadePretendida) {
        if (capacidadePretendida > this.lista.length) {
            resize(Math.max(this.lista.length * 2, capacidadePretendida));
        }
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.lista[0];
    }

    public int getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.lista[this.tamanho-1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException();
        }
        return this.lista[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vazia.");
        }
        int first = this.lista[0];
        shiftEsquerda(0);
        this.tamanho -= 1;
        return first;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vazia.");
        }
        this.tamanho -= 1;
    }

    // remove o valor no índice passado como parâmetro.
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (index < 0 || index > this.tamanho) {
            throw new IndexOutOfBoundsException();
        }
        shiftEsquerda(index);
        this.tamanho -= 1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for (int i = 0; i < tamanho; i++) {
            if (this.lista[i] == value) remove(i);
            break;
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < tamanho; i++) {
            if (this.lista[i] == value) return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
        for (int i = tamanho-1; i >= 0; i--) {
            if (this.lista[i] == valor) return i;
        }
        return -1;
    }

    // deve retornar uma string representando a lista.
    public String toString() {
        String out = "";
        for (int i = 0; i < tamanho; i++) {
            if (i != 0) out += ", ";
            out += this.lista[i];
        }
        return out;
    }

    public int size() {
        return this.tamanho;
    }

    private void shiftDireita(int indice) {
        if (indice == this.lista.length-1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = this.tamanho; i > indice; i--) {
            this.lista[i] = this.lista[i-1];
        }
    }

    private void shiftEsquerda(int indice) {
        for (int i = indice; i < this.tamanho-1; i++) {
            this.lista[i] = this.lista[i+1];
        }
    }
}