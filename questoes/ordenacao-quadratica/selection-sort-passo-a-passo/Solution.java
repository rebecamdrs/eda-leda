import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    	String[] seq = sc.nextLine().trim().split(" ");
    	int[] v = new int[seq.length];
    	for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
    	}
    	selectionSort(v);
    }

    private static void selectionSort(int[] v) {
	for (int i = 0; i < v.length-1; i++) {
	    int iMenor = encontraMenor(v, i);
	    
	    if (i != iMenor) {
	    	int temp = v[i];
	    	v[i] = v[iMenor];
	    	v[iMenor] = temp;

	    	System.out.println(Arrays.toString(v));
    	    	if (isOrdenado(v)) break;
	    }
	}
    }

    private static int encontraMenor(int[] v, int ini) {
	int menor = ini;
	for (int i = ini; i < v.length; i++) {
	    if (v[i] < v[menor]) {
	    	menor = i;
	    }
	}
	return menor;
    }

    private static boolean isOrdenado(int[] v) {
    	for (int i = 0; i < v.length-1; i++) {
	    if (v[i] > v[i+1]) return false;
	}
	return true;
    }
}
