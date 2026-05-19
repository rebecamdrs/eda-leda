import java.util.*;
import jdk.jshell.execution.LoaderDelegate;

class LomutoAsserts {
    public static void main(String[] args) {
        LomutoAsserts t = new LomutoAsserts();
        t.lomuto();
    }

    public void lomuto() {
        Solution s = new Solution();

        //lista ordenada
        int[] a = new int[]{1, 2, 3, 4, 5};
        //lista inversa
        int[] b = new int[]{5, 4, 3, 2, 1};
        //lista nula
        int[] e = new int[]{4, 0, 0};
        //lista vazia
        int[] f = new int[]{};
        //lista com valores repetidos
        int[] g = new int[]{1, 1, 5, 6, 8, 2};
        //lista com 1 elemento
        int[] h = new int[]{1};
        //lista com 2 elementos
        int[] i = new int[]{5, 7};

        assert Arrays.equals(s.lomuto(a), new int[]{1, 2, 3, 4, 5});
        assert Arrays.equals(s.lomuto(b), new int[]{1, 4, 3, 2, 5});
        assert Arrays.equals(s.lomuto(e), new int[]{0, 0, 4});
        assert Arrays.equals(s.lomuto(f), new int[]{});
        assert Arrays.equals(s.lomuto(g), new int[]{1, 1, 2, 6, 8, 5});
        assert Arrays.equals(s.lomuto(h), new int[]{1});
        assert Arrays.equals(s.lomuto(i), new int[]{5, 7});
    }
}