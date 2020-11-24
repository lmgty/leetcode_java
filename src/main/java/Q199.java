import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(7);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root,res);
        return res;

    }

    private static void bfs(TreeNode root, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        // 在队列中的节点个数
        int numsOfThisLevel = 1;
        int numsOfNextLevel = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            numsOfThisLevel--;
            if (node.left != null) {
                queue.offer(node.left);
                numsOfNextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                numsOfNextLevel++;
            }
            if (numsOfThisLevel == 0){
                res.add(node.val);
                numsOfThisLevel = numsOfNextLevel;
                numsOfNextLevel = 0;
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
