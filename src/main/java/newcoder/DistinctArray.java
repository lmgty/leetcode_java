package newcoder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author LiuYe
 * @date 2021/3/28 1:34 下午
 */
public class DistinctArray {
    public static void main(String[] args) {
        int[] arrs={1,2,5,2,45,6,23,6,3,4,3,6,5,1};
        int[] ints = distinctArr(arrs);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] distinctArr(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (Integer integer : set) {
            res[k++] = integer;
        }
        return res;
    }
}
