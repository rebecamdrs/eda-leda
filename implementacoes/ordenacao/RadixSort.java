class RadixSort {
    public void radixSort(int[] v) {
        int d = String.valueOf(getMax(v)).length();
        int exp = 1;
        while (d / exp > 0) {
            countingSort(v, exp);
            exp *= 10;
        }
    }

    private void countingSort(int[] v, int exp) {
        int[] c = new int[10];
        int digito;

        for (int i = 0; i < v.length; i++) {
            digito = (v[i] / exp) % 10;
            c[digito]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for (int i = v.length-1; i >= 0; i--) {
            digito = (v[i] / exp) % 10;
            b[c[digito]-1] = v[i];
            c[digito]--;
        }

        for (int i = 0; i < b.length; i++) {
            v[i] = b[i];
        }
    }

    private int getMax(int[] v) {
        int max = v[0];
        for (int num : v) {
          if (num > max) max = num;
        }
        return max;
    }
}