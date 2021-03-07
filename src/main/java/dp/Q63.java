package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 11:06 上午
 */
public class Q63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0}};
        uniquePathsWithObstacles(obstacleGrid);

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j] -> 到 [i,j] 格子的不同路径数
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                continue;
            }
            dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
