import java.util.HashMap;

/**
 * @author LiuYe
 * @date 2020/9/8 8:10 下午
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        String s = "abba";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
