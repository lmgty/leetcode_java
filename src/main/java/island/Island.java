package island;

/**
 * @author LiuYe
 * @date 2021/3/14 11:34 上午
 */
public class Island {
    private static void dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
    }

    private static boolean inArea(int[][] grid, int r, int c) {
        int maxR = grid.length - 1;
        int maxC = grid[0].length - 1;

        return (r >= 0 && r <= maxR) && (c >= 0 && c <= maxC);
    }
}
