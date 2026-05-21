class RadixSort {

    public void radixSort(int[] v) {
        // Conta quantos negativos existem
        int qtdNegativos = 0;
        for (int num : v) {
            if (num < 0) {
                qtdNegativos++;
            }
        }

        int[] negativos = new int[qtdNegativos];
        int[] positivos = new int[v.length - qtdNegativos];

        int iNeg = 0;
        int iPos = 0;

        // Separa negativos e positivos
        for (int num : v) {
            if (num < 0) 
                negativos[iNeg++] = -num;
            else 
                positivos[iPos++] = num;
        }

        // Ordena ambos
        radix(negativos);
        radix(positivos);

        int k = 0;

        // Negativos em ordem reversa
        for (int i = negativos.length - 1; i >= 0; i--) {
            v[k++] = -negativos[i];
        }

        // Positivos em ordem normal
        for (int i = 0; i < positivos.length; i++) {
            v[k++] = positivos[i];
        }
    }

    // Radix tradicional
    private void radix(int[] v) {
        if (v.length == 0) return;
        int max = getMax(v);
        int exp = 1;
        while (max / exp > 0) {
            countingSort(v, exp);
            exp *= 10;
        }
    }

    private void countingSort(int[] v, int exp) {
        int[] c = new int[10];

        // Frequência
        for (int i = 0; i < v.length; i++) {
            int digito = (v[i] / exp) % 10;
            c[digito]++;
        }

        // Soma acumulada
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        int[] b = new int[v.length];

        // Estável
        for (int i = v.length - 1; i >= 0; i--) {
            int digito = (v[i] / exp) % 10;
            b[c[digito] - 1] = v[i];
            c[digito]--;
        }

        // Copia de volta
        for (int i = 0; i < v.length; i++) {
            v[i] = b[i];
        }
    }

    private int getMax(int[] v) {
        int max = v[0];
        for (int num : v) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}