import java.util.LinkedList;

/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class SumRootToLeafNumbers129 {
    static int res = 0;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        new SumRootToLeafNumbers129().sumNumbers(root);
        System.out.println(res);

    }

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int pathSum) {
        int tmpNum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += tmpNum;
            return;
        }

        if (root.left != null){
            dfs(root.left, tmpNum);
        }
        if (root.right != null){
            dfs(root.right, tmpNum);
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
