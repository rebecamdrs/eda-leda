import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] a = new int[seq.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(seq[i]);
        }
        int k = sc.nextInt();
        countingSort(a, k);
    }

    public static void countingSort(int[] a, int k) {
        // array de contagem do tamanho do maior valor k + 1 (incluindo 0)
        int[] c = new int[k+1];

        //frequencia
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
            System.out.println(formataArray(c));
        }

        //acumulativa
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + formataArray(c));
        
        // array de saída do tamanho da lista a
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[c[a[i]]-1] = a[i];
            c[a[i]]--;
        }

        System.out.println(formataArray(c));
        System.out.println(formataArray(b));
    }

    private static String formataArray(int[] v) {
        String out = "";
        for (int n : v) {
            out += n + " ";
        }
        return out.trim();
    }
}