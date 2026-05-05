import java.util.*;

class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

	String[] seq = sc.nextLine().trim().split(" ");
	int[] v = new int[seq.length];
	for (int i = 0; i < v.length; i++) {
	    v[i] = Integer.parseInt(seq[i]);
	}
	insertionSort(v, v.length);
    }

    private static void insertionSort(int[] v, int k) {
	if (k <= 1) return;

	insertionSort(v, k-1);

	int ultimo = v[k-1];
	int j = k-2;
	while (j >= 0 && v[j] > ultimo) {
	    v[j+1] = v[j];
	    j--;
	}
	v[j+1] = ultimo;

	System.out.println(Arrays.toString(v));
    }
}
