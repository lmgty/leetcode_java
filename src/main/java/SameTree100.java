/**
 * @author LiuYe
 * @date 2020/10/12 8:27 下午
 */
public class SameTree100 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(11);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(20);

        TreeNode root2 = new TreeNode(11);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);

        System.out.println(isSameTree(root1,root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);

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
