package dp;

/**
 * @author LiuYe
 * @date 2021/3/3 9:31 下午
 * 给定两个字符串，求最长公共子序列
 */
public class LCS {
    public static void main(String[] args) {
        String str1 = "babcde";
        String str2 = "acze";
        int n = longestCommonSubsequence(str1, str2);
        System.out.println(n);
    }
    private static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        // dp[i][j] -> str1[0,i-1] yu str2[0, j-1] 的最长公共子序列长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i-1] == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }


        return dp[m][n];
    }
}
