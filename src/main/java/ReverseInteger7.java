/**
 * @author LiuYe
 * @date 2020/9/16 8:14 下午
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        int reverse = new ReverseInteger7().reverse(12345);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop >7)){
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
