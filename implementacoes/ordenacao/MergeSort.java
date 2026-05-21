class MergeSort {
    public void mergeSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, fim);
        }
    }

    private void merge(int[] v, int ini, int fim) {
        int intervalo = fim - ini;
        int[] auxiliar = new int[intervalo + 1];
        for (int i = 0; i < auxiliar.length; i++) {
            auxiliar[i] = v[ini + i];
        }

        int meio = intervalo / 2;
        int i = 0;
        int j = meio + 1;
        int k = ini;

        while (i <= meio && j <= fim) {
            if (auxiliar[i] < auxiliar[j]) {
                v[k++] = auxiliar[i++];
            } else {
                v[k++] = auxiliar[j++];
            }
        }

        while (i <= meio) {
            v[k++] = auxiliar[i++];
        }
    }
}