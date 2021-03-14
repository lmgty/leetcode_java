package dp;

/**
 * @author LiuYe
 * @date 2021/3/8 1:40 下午
 */
public class Backage01 {
    private int knapsack(int n, int w, int[] wt, int[] val) {

        // dp[i][w] 前 i 个物品，当背包容量为 w 时，的最大价值
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
