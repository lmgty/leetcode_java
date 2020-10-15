import java.util.*;

/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();

        nodes.offer(root);
        int numsOfThisLevel = 1;
        int numsOfSonLevel = 0;
        boolean needReverse = false;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            nums.add(node.val);
            if (node.left != null) {
                nodes.offer(node.left);
                numsOfSonLevel++;
            }
            if (node.right != null) {
                nodes.offer(node.right);
                numsOfSonLevel++;
            }
            if (nums.size() == numsOfThisLevel) {
                if (needReverse) {
                    Collections.reverse(nums);
                }
                ans.add(nums);
                nums = new ArrayList<>();
                numsOfThisLevel = numsOfSonLevel;
                numsOfSonLevel = 0;
                needReverse = !needReverse;
            }
        }
        System.out.println(ans);

        return ans;
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
