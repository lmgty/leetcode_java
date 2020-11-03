/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class BalancedBinaryTree110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(7);

        System.out.println(isBalanced(root));
//        System.out.println(depthOfTree(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(depthOfTree(root.left) - depthOfTree(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
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
