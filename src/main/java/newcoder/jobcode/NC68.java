package newcoder.jobcode;

/**
 * @author LiuYe
 * @data 2021/3/15
 */
public class NC68 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(4));
    }
    public static int jumpFloor(int target) {
        int dp1 = 1;
        int dp2 = 2;
        if (target == 1) {
            return dp1;
        }
        if (target == 2) {
            return dp2;
        }

        int dpi = 0;
        for (int i = 3; i <= target; i++) {
            dpi = dp1 + dp2;
            dp1 = dp2;
            dp2 = dpi;
        }
        return dpi;
    }
}