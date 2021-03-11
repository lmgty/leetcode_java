package dp;

/**
 * @author LiuYe
 * @date 2021/3/4 9:15 下午
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        // dp[i][j] -> s[i, j] 的最长回文字串长度
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
