import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	String[] seq = sc.nextLine().trim().split(" ");
	int[] v = new int[seq.length];
	for (int i = 0; i < v.length; i++) {
	    v[i] = Integer.parseInt(seq[i]);
	}
	System.out.println(Arrays.toString(moveImpostor(v)));
    }

    private static int[] moveImpostor(int[] v) {
	int posImpostor = 0;
	for (int i = 0; i < v.length-1; i++) {
	    if (v[i] > v[i+1]) {
	        posImpostor = i+1;
		break;
	    }
	}
	
	int j = posImpostor;
	while (j > 0 && v[j] < v[j-1]) {
	    int temp = v[j];
	    v[j] = v[j-1];
	    v[j-1] = temp;
	    j--;
	}
	return v;
    }
}
