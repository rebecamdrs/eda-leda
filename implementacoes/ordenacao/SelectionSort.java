class SelectionSort {

    public void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int iMenor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[iMenor]) {
                    iMenor = j;
                }
            }
            int temp = v[i];
            v[i] = v[iMenor];
            v[iMenor] = temp;
        }
    }
}