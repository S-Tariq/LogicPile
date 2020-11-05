package stariq.algorithms.array;

// Number of unique ways to climb stairs given the number of steps that can be taken.
public class ClimbingStaircase {
    public static void main(String[] args) {
        System.out.println(climbStairs1or2Iteration(4));
        System.out.println(climbStairs1or2Iteration(2));

        System.out.println(climbStairs1or2Recursion(4));
        System.out.println(climbStairs1or2Recursion(2));

        System.out.println(climbStairsRecursion(5, new int[] {1,3,5}));
        System.out.println(climbStairsIteration(5, new int[] {1,3,5}));
    }

    public static int climbStairs1or2Iteration(int n) {
        int[] climbWays = new int[n + 1];
        climbWays[0] = 1;
        climbWays[1] = 1;
        for(int i = 2; i <= n; i++) {
            climbWays[i] = climbWays[i - 1] + climbWays[i - 2];
        }
        return climbWays[n];
    }

    public static int climbStairsIteration(int n, int[] steps) {
        int[] climbWays = new int[n + 1];
        climbWays[0] = 1;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int s : steps) {
                if(i - s >= 0) {
                    sum += climbWays[i - s];
                }
            }
            climbWays[i] = sum;
        }
        return climbWays[n];
    }

    public static int climbStairs1or2Recursion(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return climbStairs1or2Recursion(n - 1) + climbStairs1or2Recursion(n - 2);
    }

    public static int climbStairsRecursion(int n, int[] steps) {
        if(n == 0) {
            return 1;
        }
        int sum = 0;
        for(int in : steps) {
            if(n - in >= 0) {
                sum += climbStairsRecursion(n - in, steps);
            }
        }
        return sum;
    }
}
