package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 10:14 上午
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Q70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        if (n < 3){
            return n;
        }
        // dp[i] -> 第 i 阶台阶的方法数
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
