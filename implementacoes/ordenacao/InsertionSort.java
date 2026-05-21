class InsertionSort {
    public void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int j = i;
            while (j > 0 && v[j] < v[j - 1]) {
                int temp = v[j];
                v[j] = v[j - 1];
                v[j - 1] = temp;
                j--;
            }
        }
    }
}