import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++)
            v[i] = Integer.parseInt(seq[i]);
        Heap heap = new Heap(v);
        heap.buildHeap();
        System.out.println(Arrays.toString(heap.heap));
    }
}

class Heap {
    private int tail;
    int[] heap;

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length-1;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    public int parent(int index) {
        return Math.floorDiv(index-1, 2);
    }

    public void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) return;

        int maxIndex = max(index, left(index), right(index));

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapify(maxIndex);
        }
    }

    public void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--) 
            heapify(i);
    }

    private boolean isLeaf(int index) {
        return index > parent(this.tail) && index <= this.tail;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    private int max(int index, int left, int right) {
        // define que o maior é o pai
        int max = index;

        // se o filho da esquerda for maior, o max agr é o left
        if (this.heap[left] > this.heap[max]) max = left;

        // se o filho da direita for maior, o max agr é o right (tem que ver se o indice rigth existe/válido)
        if (isValidIndex(right) && this.heap[right] > this.heap[max]) max = right;

        return max;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }
}