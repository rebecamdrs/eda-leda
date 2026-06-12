import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        lomuto(v);
    }

    public static int[] lomuto(int[] v) {
        if (v.length == 0) return v;

        int pivot = v[v.length-1];
        int i = v.length-1;
        for (int j = i-1; j >= 0; j--) {
            if (v[j] > pivot) {
                i--;
                swap(v, i, j);
                System.out.println(Arrays.toString(v));
            }
        }
        swap(v, v.length-1, i);
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(v));
        return v;
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}