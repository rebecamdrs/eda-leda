import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] v = sc.nextLine().trim().split(" ");

		System.out.println(posicoesElemento(n, v));
    }


    public static String posicoesElemento(int n, String[] v) {
        String out = "";
		for (int i = 0; i < v.length; i++) {
			if (Integer.parseInt(v[i]) == n) {
			out += i + " ";
			}
		}
		if (out.equals("")) {
			out = "-1";
		}
		return out.trim();
    }
}
