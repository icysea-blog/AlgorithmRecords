package recursion;

import java.util.List;

public class Hanota {
    public void hanoi(int n, char a, char b, char c) {
        if (n <= 0) {
            return;
        }
        // 将A上的n-1个盘子经过c移到b
        hanoi(n - 1, a, c, b);
        // 将A上的最后一个盘子移到c
        move(a, c);
        // 将b上的n-1个盘子经过a移到c
        hanoi(n - 1, b, a, c);
    }

    private void move(char a, char c) {
        System.out.printf("%c->%c\n", a, c);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanoi(A.size(), A, B, C);
    }

    public void hanoi(int n, List<Integer> A, List<Integer> B, List<Integer> C) {

        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
        } else {
            hanoi(n - 1, A, C, B);
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            hanoi(n - 1, B, A, C);
        }
    }
}

