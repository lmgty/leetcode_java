/**
 * @author LiuYe
 * @date 2020/9/16 8:57 下午
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int origin = x;
        int res = 0;
        while (x > 0) {
            int pop = x % 10;
            x = x / 10;
            res = res * 10 + pop;
        }
        return res == origin;
    }
}
