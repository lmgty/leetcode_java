import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q404 {
    private static int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(sumOfLeftLeaves(root));


    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root ==null){
            return 0;
        }
        return dfs(root,false);
    }

    private static int dfs(TreeNode root, boolean isLeft){
        int res = 0;
        if (root.left != null){
            res += dfs(root.left, true);
        }
        if (root.right != null){
            res += dfs(root.right, false);
        }
        if (root.left == null && root.right == null && isLeft){
            res += root.val;
        }
        return res;
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
