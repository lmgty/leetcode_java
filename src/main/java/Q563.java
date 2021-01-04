import java.util.List;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q563 {
    public int findTilt(TreeNode root) {
        return sumTilt(root);
    }

    private int sumTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calNodeTilt(root) + sumTilt(root.left) + sumTilt(root.right);
    }

    private int calNodeTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(sumVal(root.left) - sumVal(root.right));
    }


    private int sumVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumVal(root.left) + sumVal(root.right);
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


