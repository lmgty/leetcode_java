/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class PathSum112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(hasPathSum(root, 38));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    public static boolean hasPathSum(TreeNode root, int sum, int pathSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (pathSum + root.val) == sum;
        } else {
            return hasPathSum(root.left, sum, pathSum + root.val) ||
                    hasPathSum(root.right, sum, pathSum + root.val);
        }

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
