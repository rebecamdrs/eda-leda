import java.util.*;

class Main {
    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	sc.nextLine();
	String entrada = sc.nextLine();
	String[] seq = entrada.trim().split(" ");

	int frequencia = 0;
	for (String s : seq) {
	    if (Integer.parseInt(s) == n) {
	        frequencia++;
	    }
	}
	System.out.println(frequencia);
    }	
}
