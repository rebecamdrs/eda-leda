import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        System.out.println(estatisticaOrdem(v));
    }

    public static int estatisticaOrdem(int[] v) {
        int menores = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < v[0]) menores++; 
        }
        partition(v);
        return menores+1;
    }

    private static void partition(int[] v) {
        int pivot = v[0];
        int i = 0;
        for (int j = i+1; j < v.length; j++) {
            if (v[j] < pivot) {
                i++;
                swap(v, i, j);
            }
        }
        swap(v, i, 0);
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}