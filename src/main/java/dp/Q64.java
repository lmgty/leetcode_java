package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 11:06 上午
 */
public class Q64 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(obstacleGrid);

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] -> grid[i][j] 位置的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[m - 1][n - 1];

    }
}
