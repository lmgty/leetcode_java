package dp;

/**
 * @author LiuYe
 * @date 2021/3/8 12:51 下午
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Q5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        char[] chars = s.toCharArray();

        // dp[i][j] = chars[i, j] 是否是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 0;
        int begin = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j-i+1>maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen);

    }
}
