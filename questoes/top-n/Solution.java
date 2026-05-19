import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		String[] seq = sc.nextLine().trim().split(" ");
		int n = sc.nextInt(); // n >= 1 ou n == seq.length
		int[] v = new int[seq.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(seq[i]);
		}
		System.out.println(topN(v, n));
    }

    private static String topN(int[] v, int n) {
        bubbleSort(v);
		String out = "";
		for (int j = 0; j < n; j++) {
			out += v[j] + " ";
		}
		return out.trim();
    }

    private static void bubbleSort(int[] v) {
        for (int i = 0; i < v.length-1; i++) {
			for (int j = 0; j < v.length-1-i; j++) { 
				if (v[j] < v[j+1]) {
					int temp = v[j];
				v[j] = v[j+1];
				v[j+1] = temp;
				}
			}
		}
    }
}
