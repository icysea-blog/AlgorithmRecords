package recursion;

import java.util.HashMap;

public class ClimbingStairs {
    /**
     * leetcode 70
     *
     * @param n
     * @return 1         n = 1
     * f(n) =         2         n = 2
     * f(n-1) + f(n-2)  n >= 3
     * 复杂度为指数级
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n + 2);
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairsWithMap(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = climbStairsWithMap(n - 1) + climbStairsWithMap(n - 2);
        map.put(n, result);
        return result;
    }

    public int climbStairsWithDP(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int pre = 1, next = 2;
        int result = 0;
        for (int i = 3; i < n + 1; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }
}
