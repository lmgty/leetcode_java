package dp;

import java.util.Arrays;

/**
 * @author LiuYe
 * @date 2021/3/3 7:54 下午
 * 输入一个整数数组 nums[]，请你在其中找出一个和最大的数组，返回这个子数组的和。
 */
public class SubArray {
    public static void main(String[] args) {
        int[] nums = {-3, 1, 3, -1, 2, -4, 2};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }

    private static int maxSubArray(int[] nums) {
        // dp[i] -> 以 num[i] 为结尾的最大子数组和
        int length = nums.length;
        int[] dp = new int[length];
        int dp0 = nums[0];
        int dp1 = 0;
        int res = dp0;

        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
