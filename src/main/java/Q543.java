/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q543 {

    private int ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);

        int diameterOfBinaryTree = new Q543().diameterOfBinaryTree(root);
        System.out.println(diameterOfBinaryTree);

    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        int diameter = depth(root.left) + depth(root.right);
        if (diameter > ans) {
            ans = diameter;
        }
        dfs(root.left);
        dfs(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);

        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
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
