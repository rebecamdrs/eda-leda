import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	String[] seq = sc.nextLine().trim().split(" ");
	System.out.println(encontraPrimeiroNegativo(seq));
    }

    private static String encontraPrimeiroNegativo(String[] seq) {
        for (int i = 0; i < seq.length; i++) {
	    if (Integer.parseInt(seq[i]) < 0) {
	        return seq[i];
	    }
	}
	return "-";
    }
}
