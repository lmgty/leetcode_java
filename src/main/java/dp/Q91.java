package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 9:21 下午
 */
public class Q91 {
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        int length = s.length();
        if (!isLegal(s)) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        // dp[i] -> s[0,i]的解码方法总数
        int[] dp = new int[length];
        dp[0] = 1;


//todo
//        dp[i] = dp[i-1]+dp[i-2];
        return 0;
    }

    private boolean isLegal(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (i == 0) {
                    return false;
                }
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return false;
                }
            }
        }
        return true;
    }
}
