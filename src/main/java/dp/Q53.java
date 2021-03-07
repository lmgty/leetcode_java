package dp;

/**
 * @author LiuYe
 * @date 2021/3/7 10:34 上午
 */
public class Q53 {
    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;

        // dp[i] -> nums[i] 为结尾的连续子数组的最大和
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
