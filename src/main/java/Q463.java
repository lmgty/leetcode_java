/**
 * @author LiuYe
 * @date 2021/3/14 11:57 上午
 */
public class Q463 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private static int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = 2;

        return dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1);
    }

    private static boolean inArea(int[][] grid, int r, int c) {
        int maxR = grid.length - 1;
        int maxC = grid[0].length - 1;

        return (r >= 0 && r <= maxR) && (c >= 0 && c <= maxC);
    }
}
