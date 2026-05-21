class CountingSort {
    public int[] countingSort(int[] v) {
        int[] c = new int[getMax(v)];

        for (int i = 0; i < v.length; i++) {
            c[v[i]-1]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for (int i = b.length-1; i >= 0; i--) {
            b[c[v[i]-1]-1] = v[i];
            c[v[i]-1]--;
        }
        return b;
    }

    public int[] countingSortZero(int[] v) {
        int[] c = new int[getMax(v)+1];

        for (int i = 0; i < v.length; i++) {
            c[v[i]]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for (int i = b.length-1; i >= 0; i--) {
            b[c[v[i]]-1] = v[i];
            c[v[i]]--;
        }
        return b;
    }

    public int[] countingSortNegativos(int[] v) {
        int menor = getMin(v);
        int[] c = new int[getMax(v)+1-menor];

        for (int i = 0; i < v.length; i++) {
            c[v[i]-menor]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        int[] b = new int[v.length];
        for (int i = b.length-1; i >= 0; i--) {
            b[c[v[i]-menor]-1] = v[i];
            c[v[i]-menor]--;
        }
        return b;
    }

    private int getMin(int[] v) {
        int min = v[0];
        for (int num : v) {
          if (num < min) min = num;
        }
        return min;
    }

    private int getMax(int[] v) {
        int max = v[0];
        for (int num : v) {
          if (num > max) max = num;
        }
        return max;
    }
}