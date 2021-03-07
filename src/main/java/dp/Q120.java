package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiuYe
 * @date 2021/3/7 9:54 下午
 */
public class Q120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(4,1,8,3));
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        minimumTotal(triangle);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                List<Integer> preList = triangle.get(i - 1);
                List<Integer> curList = triangle.get(i);
                if (j == i) {
                    dp[i][j] = dp[i-1][j - 1] + curList.get(j);
                }else {
                    dp[i][j] = Math.min(dp[i-1][j - 1] + curList.get(j), dp[i-1][j] + curList.get(j));
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            minLength = Math.min(dp[n - 1][k], minLength);
        }
        return minLength;
    }
}
