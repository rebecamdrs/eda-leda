import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().trim().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
        }
        System.out.println(Arrays.toString(insereUltimo(v)));
    }
}
