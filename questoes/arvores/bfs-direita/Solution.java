import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");

        BST bst = new BST();
        for (String s : seq) {
            bst.add(Integer.parseInt(s));
        }

        bst.bfs();
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
    /**
     * Calcula a altura da árvore (ou subárvore) cuja raiz é "node".
     * A altura de uma árvore vazia é -1.
     */
    public int heigth(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heigth(node.left), heigth(node.right));
    }

    public void bfs() {
        Deque<Node> queue = new LinkedList<>();

        if (!isEmpty()) {
            queue.addLast(root);

            boolean primeiro = true;

            while (!queue.isEmpty()) {
                Node atual = queue.removeFirst();

                if (!primeiro) System.out.print(" ");
                System.out.print(atual.value);
                primeiro = false;

                if (atual.right != null)
                    queue.addLast(atual.right);

                if (atual.left != null)
                    queue.addLast(atual.left);
            }
            System.out.println();
        }
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