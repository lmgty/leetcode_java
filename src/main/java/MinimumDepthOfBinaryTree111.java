/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class MinimumDepthOfBinaryTree111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
//        root.right.right.right.right = new TreeNode(5);


        System.out.println(minDepth(root));
//        System.out.println(depthOfTree(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return minDepthHelper(root);
    }

    private static int minDepthHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null){
            return minDepth(root.left) + 1;
        }else {
            return minDepth(root.right) + 1;
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
