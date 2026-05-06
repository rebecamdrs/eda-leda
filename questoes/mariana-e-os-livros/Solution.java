import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] estante = sc.nextLine().trim().split(",");
        insertionSort(estante);
    }

    private static void insertionSort(String[] seq) {
        for (int i = 1; i < seq.length; i++) {
            int k = i;
            while (k > 0 && seq[i].compareToIgnoreCase(seq[k-1]) < 0) {
                String temp = seq[k];
                seq[k] = seq[k-1];
                seq[k-1] = temp;
                k--;
            }
            System.out.println(formatador(seq));
        }
    }

    private static String formatador(String[] seq) {
        String out = "";
        for (int i = 0; i < seq.length; i++) {
            if (seq[i].equals()) 
            out += livro + ", ";

        }
        return out.trim();
    }
}
