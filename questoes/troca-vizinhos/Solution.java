import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String[] seq = sc.nextLine().trim().split(" ");
		int[] v = new int[seq.length];
		for (int i = 0; i < seq.length; i++) {
			v[i] = Integer.parseInt(seq[i]);
		}
		System.out.println(Arrays.toString(trocaVizinhos(v)));
    }

    private static int[] trocaVizinhos(int[] v) {
        for (int i = 0; i < v.length-1; i+=2) {
			int temp = v[i];
			v[i] = v[i+1];
			v[i+1] = temp;
		}
		return v;
    }
}
