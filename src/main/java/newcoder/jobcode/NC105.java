package newcoder.jobcode;

/**
 * @author LiuYe
 * @data 2021/3/11
 */
public class NC105 {
    public int search (int[] nums, int target) {
        int index = binSearch(nums, target);
        if (index == -1){
            return index;
        }
        return findLeftSame(nums,index);

    }

    private int binSearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findLeftSame(int[] nums, int index) {
        while (index > 0) {
            if (nums[index] != nums[index - 1]){
                return index;
            }
            index--;
        }
        return index;
    }
}
