import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        quickSort(v, 0, v.length-1);
    }

    private static void quickSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int indexPivot = partition(v, ini, fim);
            quickSort(v, ini, indexPivot-1);
            quickSort(v, indexPivot+1, fim);
        }
    }

    private static int partition(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
        }
        swap(v, ini, i);
        printArray(v);
        return i;
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private static void printArray(int[] v) {
        String out = "";
        for (int i : v) {
            out += i + " ";
        }
        System.out.println(out.trim());
    }
}