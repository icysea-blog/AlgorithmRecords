package recursion;

public class Factorial {
    /**
     * @param n
     * @return n!
     * f(n) = f(n-1) * n
     * TC: O(n)
     */
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
