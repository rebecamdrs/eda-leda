import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        moveN(v);

    }

    private static void moveN(int[] v) {
        int pos = 0;
        for (int i = 0; i < v.length-1; i++) {
            if (v[i+1] < v[i]) {
                pos = i+1;
                break;
            }
        }

        for (int j = pos; j < v.length; j++) {
            selectionSort(v, j);
        }
    }

    private static void selectionSort(int[] v, int posicao) {
        int j = posicao;
        while (j > 0 && v[j-1] > v[j]) {
            int temp = v[j];
            v[j] = v[j-1];
            v[j-1] = temp;

            System.out.println(Arrays.toString(v));

            j--;
        }
    }
}
