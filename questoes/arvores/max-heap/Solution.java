import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++)
            v[i] = Integer.parseInt(seq[i]);
        Heap heap = new Heap(v);
        System.out.println(heap.isMaxHeap());
    }
}

class Heap {
    private int tail;
    private int[] heap;

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
    }

    public boolean isMaxHeap() {
        if (isEmpty()) return false;

        int lastParentIndex = parent(this.tail);

        for (int i = 0; i <= lastParentIndex; i++) {
            int left = left(i);
            int rigth = rigth(i);

            if (isValidIndex(left) && maxIndex(i, left, rigth) != i) return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int indice) {
        return indice * 2 + 1;
    }

    public int rigth(int indice) {
        return indice * 2 + 2;
    }

    public int parent(int indice) {
        return Math.floorDiv(indice-1, 2);
    }

    private boolean isValidIndex(int indice) {
        return indice >= 0 && indice <= this.tail;
    }

    private int maxIndex(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {

            if (isValidIndex(right) && this.heap[index] < this.heap[right]) return right;

            return index;
        
        } else {
            
            if (isValidIndex(right) && this.heap[left] < this.heap[right]) return right;
            
            return left;
        }
    }

}