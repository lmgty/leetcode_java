/**
 * @author LiuYe
 * @date 2021/3/14 11:57 上午
 */
public class Q695 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea,area(grid, i, j));
            }
        }
        return maxArea;
    }

    private static int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;

        return 1
                + area(grid, r - 1, c)
                + area(grid, r, c + 1)
                + area(grid, r + 1, c)
                + area(grid, r, c - 1);
    }

    private static boolean inArea(int[][] grid, int r, int c) {
        int maxR = grid.length - 1;
        int maxC = grid[0].length - 1;

        return (r >= 0 && r <= maxR) && (c >= 0 && c <= maxC);
    }
}
