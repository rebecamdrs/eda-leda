import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	String[] seq = sc.nextLine().trim().split(" ");
	int n = sc.nextInt();

	System.out.println(vetorCircular(seq, n));
    }

    private static String vetorCircular(String[] seq, int n) {
        String out = "";
	int indice = 0;
	for (int i = 0; i < n; i++) {
	    out += seq[indice] + " ";
	    if (indice == seq.length-1) {
	        indice = 0;
	    } else {
	        indice++;
	    }
	}
	return out.trim();
    }
}
