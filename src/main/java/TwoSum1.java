import java.util.Arrays;
import java.util.HashMap;

/**
 * @author LiuYe
 * @date  ${DATE} ${TIME}
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 7, 5};
        int target = 9;
        int[] twoSum = new TwoSum1().twoSum(ints, target);
        System.out.println(Arrays.toString(twoSum));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(length);

        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
