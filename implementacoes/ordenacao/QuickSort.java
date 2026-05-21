class QuickSort {
    public void quickSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int iPivot = particionamentoLomuto(v, ini, fim);
            quickSort(v, ini, iPivot-1);
            quickSort(v, iPivot+1, fim);
        }
    }

    private int particionamentoLomuto(int[] v, int ini, int fim) {
        int meio = (ini + fim) / 2;
        swap(v, ini, mediana(v, ini, meio, fim));
        int pivot = v[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (v[j] < pivot) {
                i++;
                swap(v, i, j);
            } 
        }
        swap(v, ini, i);
        return i;
    }

    private int mediana(int[] v, int ini, int meio, int fim) {
        int[] sorted = new int[]{v[ini], v[meio], v[fim]};
        insertionSort(sorted);
        if (sorted[1] == v[ini]) return ini;
        else if (sorted[1] == v[meio]) return meio;
        else return fim;

    }

    private void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int j = i;
            while (j > 0 && v[j] < v[j-1]) {
                swap(v, j, j-1);
                j--;
            }
        }
    }

    private void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}