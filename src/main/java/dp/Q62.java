package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 11:06 上午
 */
public class Q62 {
    public static void main(String[] args) {
        uniquePaths(3, 7);

    }

    public static int uniquePaths(int m, int n) {

        // dp[i][j] -> 到 [i,j] 格子的不同路径数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
