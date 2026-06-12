import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        int d = sc.nextInt();
        radixSort(v, d);
    }

    public static void radixSort(int[] v, int d) {
        int exp = 1;
        for (int i = 0; i < d / 2; i++) {
            countingSort(v, exp);
            System.out.println(Arrays.toString(v));
            exp *= 100;
        }
    }

    private static void countingSort(int[] a, int exp) {
        int[] c = new int[100];

        // frequencia
        for (int i = 0; i < a.length; i++) {
            int digito = (a[i] / exp ) % 100;
            c[digito]++;
        }

        //acumulativa
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        // monta o array ordenado de trás pra frente para manter estabilidade
        int[] b = new int[a.length];
        for (int i = b.length-1; i >= 0; i--) {
            int digito = (a[i] / exp ) % 100;
            b[c[digito]-1] = a[i];
            c[digito]--;
        }

        // copia para o array original
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}