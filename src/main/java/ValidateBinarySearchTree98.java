/**
 * @author LiuYe
 * @date 2020/9/24 10:04 下午
 */
public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println(isValidBST(root));
    }


    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        if (!helper(root.left,lower,root.val)){
            return false;
        }
        if (!helper(root.right,root.val, upper)){
            return false;
        }
        return true;
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
