import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int maxI = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxI]);
        root.left = construct(nums, left, maxI);
        root.right = construct(nums, maxI + 1, right);
        return root;
    }

    private int maxIndex(int[] nums, int left, int right) {
        int maxI = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


