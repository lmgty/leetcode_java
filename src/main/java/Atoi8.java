/**
 * @author LiuYe
 * @date 2020/9/16 8:29 下午
 */
public class Atoi8 {
    public static void main(String[] args) {
        int i = new Atoi8().myAtoi("2147483648");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 1) {
            return 0;
        }

        int i = 0;
        int flag = 1;
        while (chars[i] == ' ') {
            i++;
            if (i > chars.length - 1) {
                return 0;
            }
        }

        if (chars[i] == '+' || chars[i] == '-' || (chars[i] <= '9' && chars[i] >= '0')) {
            if (chars[i] == '+') {
                flag = 1;
                i++;
            } else if (chars[i] == '-') {
                flag = -1;
                i++;
            }
            int res = 0;
            while (i < chars.length && (chars[i] <= '9' && chars[i] >= '0')) {
                int num = ((int) chars[i] - (int) '0') * flag;
                if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && num > 7) return Integer.MAX_VALUE;
                if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && num < -8) return Integer.MIN_VALUE;
                res = res * 10 + num;
                i++;
            }
            return res;
        }
        return 0;

    }
}
