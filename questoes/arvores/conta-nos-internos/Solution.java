import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");

        BST bst = new BST();
        for (String s : seq) {
            bst.add(Integer.parseInt(s));
        }

        System.out.println(bst.contaInternos());
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

    public int contaInternos() {
        return contaInternos(this.root);
    }

    private int contaInternos(Node node) {
        if (node == null) return 0;

        // É folha
        if (node.left == null && node.right == null)
            return 0;

        // É nó interno
        return 1 + contaInternos(node.left) + contaInternos(node.right);
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