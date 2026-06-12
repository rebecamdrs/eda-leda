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
        int j = sc.nextInt(); //sempre negativo
        countingSort(a, k, j);
    }

    public static void countingSort(int[] a, int k, int j) {
        int[] c = new int[k + 1 - j];

        //frequencia 
        for (int i = 0; i < a.length; i++) {
            c[a[i]-j]++;
            System.out.println(Arrays.toString(c));
        }

        //acumulativa 
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));

        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[c[a[i]-j]-1] = a[i];
            c[a[i]-j]--;
        }
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(b));
    }
}