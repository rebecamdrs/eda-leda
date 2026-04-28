import java.util.*;

class Solucao {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	sc.nextLine();
	int j = sc.nextInt();

	List<Integer> saida = new ArrayList<>();
	
	int maiorSeq = 0;
	for (int n = i; n <= j; n++) {
	    int seq = contador(n);
	    if (seq > maiorSeq) {
		maiorSeq = seq;
	    }
	}

	System.out.println(maiorSeq);
    }

    private static int contador(int n) {
	int cont = 1;
	while (n != 1) {
	    if (n % 2 == 0) {
	        n = n / 2;
            } else {
                n = n * 3 + 1;
            }
	    cont++;
	}
	return cont;
    }
}
