package newcoder.jobcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuYe
 * @data 2021/3/15
 */
public class NC61 {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 4, 7, 8, 5, 9};
        int target = 10;
        int[] res = twoSum(numbers,target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        // a(target - b) -> i
        // b(target - a) -> i
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            Integer targetI = map.get(target - numbers[i]);
            if (targetI != null) {
                res[0] = Math.min(i, targetI) + 1;
                res[1] = Math.max(i, targetI) + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return res;
    }
}
