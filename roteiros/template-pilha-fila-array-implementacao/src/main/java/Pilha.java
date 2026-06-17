public class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.pilha.length - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull()) {
            throw new IllegalStateException("A pilha está cheia.");
        }
        this.topo += 1;
        this.pilha[topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        int elemento = this.pilha[topo];
        this.topo -= 1;
        return elemento;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return this.pilha[topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        if (isEmpty()) return "";

        Pilha aux = new Pilha(this.pilha.length);
        String out = "";

        while (!isEmpty()) {
            aux.push(pop());
        }

        while (!aux.isEmpty()) {
            int elemento = aux.pop();
            push(elemento);

            if (out.equals("")) {
                out += elemento;
            } else {
                out += ", " + elemento;
            }
        }

        return out;
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);

        int indice = -1;
        int i = this.topo;

        while (!isEmpty()) {
            int elemento = pop();

            if (elemento == valor && indice == -1) {
                indice = i;
            }

            aux.push(elemento);
            i--;
        }

        while (!aux.isEmpty()) {
            push(aux.pop());
        }

        return indice;
    }

    public int lastIndexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);

        int indice = -1;
        int i = this.topo;

        while (!isEmpty()) {
            int elemento = pop();

            if (elemento == valor) {
                indice = i;
            }

            aux.push(elemento);
            i--;
        }

        while (!aux.isEmpty()) {
            push(aux.pop());
        }

        return indice;
    }

    public int size() {
        return this.topo + 1;
    }

}
