import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiuYe
 * @date 2021/3/7 9:47 上午
 */
public class Q1047 {
    public static void main(String[] args) {
        String str = removeDuplicates("abbaca");
        System.out.println(str);

    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (length != 0 && sb.charAt(length - 1) == s.charAt(i)) {
                sb.deleteCharAt(length - 1);
                length--;
            } else {
                sb.append(s.charAt(i));
                length++;
            }
        }
        return sb.toString();
    }
}
