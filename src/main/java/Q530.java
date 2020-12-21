import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q530 {

    private int pre;
    private int ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);

        int minimumDifference = new Q530().getMinimumDifference(root);
        System.out.println(minimumDifference);

    }

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        def(root);
        return ans;
    }

    private void def(TreeNode root) {
        if (root == null) {
            return;
        }
        def(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(pre - root.val));
        }
        pre = root.val;
        def(root.right);
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
