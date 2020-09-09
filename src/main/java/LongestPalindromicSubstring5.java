/**
 * 暴力法采用双指针两边夹，验证是否是回文子串。
 * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”
 * ，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
 * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
 *
 * @author LiuYe
 * @date 2020/9/9 8:28 下午
 */
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "babad";
        String longestPalindrome = new LongestPalindromicSubstring5().longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }
}
