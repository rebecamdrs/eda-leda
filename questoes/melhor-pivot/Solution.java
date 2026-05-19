import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }

        String[] indices = sc.nextLine().trim().split(" ");
        int i = Integer.parseInt(indices[0]);
        int j = Integer.parseInt(indices[1]);

        System.out.println(melhorPivot(v, i, j));
    }

    public static int melhorPivot(int[] v, int i, int j) {
        //calcula a quantidade de maiores e menores de cada e vÊ qual é menor
        int difI = diferenca(v, v[i]);
        int difJ = diferenca(v, v[j]);

        if (difI <= difJ) {
            return i;
        } else {
            return j;
        }
    }

    private static int diferenca(int[] v, int pivot) {
        int maiores = 0;
        int menores = 0;

        for (int num : v) {
            if (num < pivot) {
                menores++;
            } else if (num > pivot) {
                maiores++;
            }
        }
        return absoluto(menores, maiores);
    }

    private static int absoluto(int n1, int n2) {
        int subtracao = n1 - n2;
        int absoluto = (subtracao < 0) ? -subtracao : subtracao;
        return absoluto;
    }
}