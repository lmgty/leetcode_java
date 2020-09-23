import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiuYe
 * @date 2020/9/21 9:23 下午
 */
public class Sum3Num15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = new Sum3Num15().threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums) return res;
        int length = nums.length;
        if (length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    res.add(integers);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right-1] == nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }
            }
        }
        return res;
    }

}
