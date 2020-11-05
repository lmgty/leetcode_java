import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class PathSumTwo113 {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new PathSumTwo113().pathSum(root, 38));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
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
