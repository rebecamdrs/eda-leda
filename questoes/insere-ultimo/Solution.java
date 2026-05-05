import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
	insercaoOrdenada(v);
        System.out.println(Arrays.toString(v));
    }

    private static void insercaoOrdenada(int[] v) {
    	for (int i = v.length-1; i > 0; i--) {
	    if (v[i] < v[i-1]) {
	    	int temp = v[i];
		v[i] = v[i-1];
		v[i-1] = temp;
	    }
	}
    }
}
