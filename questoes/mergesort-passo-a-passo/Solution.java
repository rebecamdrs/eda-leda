import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        mergeSort(v, 0, v.length-1);
    }

    private static void mergeSort(int[] v, int ini, int fim) {
        printArray(v, ini, fim);
        if (ini < fim) {
            int meio = (ini+fim)/2;
            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, fim);
            printArray(v, ini, fim);
        }
    }

    private static void merge(int[] v, int ini, int fim) {
        int tamanho = fim - ini; 
        int[] aux = new int[tamanho+1];
        for (int i = 0; i <= tamanho; i++) {
            aux[i] = v[ini + i]; // temos q considerar de onde vamos começar
        } 

        int meio = tamanho / 2;

        int i = 0;
        int j = meio + 1;
        int k = ini;

        while (i <= meio && j <= tamanho) {
            if (aux[i] <= aux[j]) {
                v[k++] = aux[i++];
            } else {
                v[k++] = aux[j++];
            }
        }

        while (i <= meio) {
            v[k++] = aux[i++];
        }
    }

    private static void printArray(int[] v, int ini, int fim) {
        System.out.print("[");
        for (int i = ini; i <= fim; i++) {
            System.out.print(v[i]);
            if (i < fim) System.out.print(", ");
        }
        System.out.println("]");
    }
}