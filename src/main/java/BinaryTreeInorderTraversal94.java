import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYe
 * @date 2020/9/24 9:04 下午
 */
public class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<Integer>();
        if (root == null) return integers;
        if (root.left != null) {
            List<Integer> integersLeft = inorderTraversal(root.left);
            integers.addAll(integersLeft);
        }
        integers.add(root.val);
        if (root.right != null) {
            List<Integer> integersRight = inorderTraversal(root.right);
            integers.addAll(integersRight);
        }
        return integers;
    }
}

class TreeNode {
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