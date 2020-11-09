import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        new FlattenBinaryTreeToLinkedList114().flatten(root);
        System.out.println();
    }

    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
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
