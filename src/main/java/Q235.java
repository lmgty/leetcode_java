/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(5);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int compareRootP = compareNode(root, p);
        int compareRootQ = compareNode(root, q);
        if (compareRootP * compareRootQ == -1) {
            return root;
        }
        if (compareRootP == 0 || compareRootQ == 0) {
            return root;
        }
        if (compareRootP == 1 && compareRootQ == 1) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    private static int compareNode(TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return 1;
        } else if (p.val < q.val) {
            return -1;
        } else {
            return 0;
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
