import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");

        BST bst = new BST();
        for (String s : seq) {
            bst.add(Integer.parseInt(s));
        }

        System.out.println(bst.somaFolhas());
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
            Node atual = this.root;
            while (atual != null) {
                if (n < atual.value) {
                    if (atual.left == null) {
                        Node newNode = new Node(n);
                        atual.left = newNode;
                        newNode.parent = atual;
                        return;
                    }
                    atual = atual.left;
                } else {
                    if (atual.right == null) {
                        Node newNode = new Node(n);
                        atual.right = newNode;
                        newNode.parent = atual;
                        return;
                    }
                    atual = atual.right;
                }
            }
        }
    }

    public int heigth(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heigth(node.left), heigth(node.right));
    }

    public int somaFolhas() {
        return somaFolhas(this.root);
    }

    private int somaFolhas(Node node) {
        if (node == null) return 0;
        int soma = 0;

        if (node.left == null && node.right == null) return node.value;
        else {
            if (node.left != null) soma += somaFolhas(node.left);
            if (node.right != null) soma += somaFolhas(node.right);
        }
        return soma;
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