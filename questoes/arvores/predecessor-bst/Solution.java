import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");

        BST bst = new BST();
        for (String s : seq) {
            bst.add(Integer.parseInt(s));
        }

        int valor = sc.nextInt();

        bst.predecessor(valor);
    }
}

class BST {
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int n) {
        this.size++;
        if (isEmpty()) {
            this.root = new Node(n);
        } else {
            Node aux = this.root;

            while (aux != null) {
                if (n < aux.value) {
                    if (aux.left == null) {
                        Node newNode = new Node(n);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(n);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    
    private Node search(int valor) {
        Node aux = this.root;

        while (aux != null) {
            if (valor == aux.value) return aux;
            if (valor < aux.value) aux = aux.left;
            if (valor > aux.value) aux = aux.right;
        }

        return null;
    }

    public void predecessor(int valor) {
        List<Integer> caminho = new ArrayList<>();

        Node node = search(valor);
        caminho.add(node.value);

        // Caso 1: existe subárvore esquerda
        if (node.left != null) {
            node = node.left;
            caminho.add(node.value);

            while (node.right != null) {
                node = node.right;
                caminho.add(node.value);
            }
        }
        // Caso 2: não existe subárvore esquerda
        else {
            while (node.parent != null) {
                node = node.parent;
                caminho.add(node.value);

                if (node.value < valor)
                    break;
            }
        }

        System.out.println(caminho);
    }
}

class Node {
    int value;
    Node left;
    Node right;
    Node parent;
    
    public Node(int v) {
        this.value = v;
    }
}