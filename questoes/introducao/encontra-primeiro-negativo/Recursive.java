import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] v = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            v[i] = Integer.parseInt(entrada[i]);
        }

        System.out.println(encontraPrimeiroNegativo(v, 0));
    }

    public static String encontraPrimeiroNegativo(int[] v, int i) {
        // caso base: chegou ao fim
        if (i >= v.length) {
            return "-";
        }

        // caso base: encontrou negativo
        if (v[i] < 0) {
            return String.valueOf(v[i]);
        }

        // chamada recursiva
        return encontraPrimeiroNegativo(v, i + 1);
    }
}
