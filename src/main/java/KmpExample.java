import java.util.Arrays;

/**
 * @author LiuYe
 * @data 2020/10/16
 */
public class KmpExample {
    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println(kmpSearch(s, p, next));
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    public static int[] kmpNext(String dest) {
        int length = dest.length();
        int[] next = new int[length];

        next[0] = 0;
        int j = 0;

        for (int i = 1; i < length; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    /**
     * 暴力解法。
     * 关键：i 回溯，j 归零
     */
    public static int violence(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        int i = 0;
        int j = 0;

        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        while (i < sLength && j < pLength) {
            if (arrS[i] == arrP[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLength) {
            return i - j;
        } else {
            return -1;
        }
    }
}
