import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		String[] seq = sc.nextLine().trim().split(" ");
		int[] v = new int[seq.length];
		for (int i = 0; i < seq.length; i++) {
			v[i] = Integer.parseInt(seq[i]);
		}
		moveTres(v);

    }

    private static void moveTres(int[] v) {
        int[] posicoes = new int[3];
		for (int i = 0; i < v.length-1; i++) {
			if (v[i] > v[i+1]) {
				posicoes[0] = i + 1;
				posicoes[1] = i + 2;
				posicoes[2] = i + 3;
				break;
			}
		}
	
		for (int j = 0; j < posicoes.length; j++) {
			selectionSort(v, posicoes[j]);
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
