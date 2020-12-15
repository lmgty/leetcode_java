import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q515 {
    private List<Integer> res = new ArrayList<>();
    private int currentElement, currentCount, maxCount;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);

        List<Integer> list = new Q515().largestValues(root);
        System.out.println();

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            bfs(root, res);
        }
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        int maxVal = root.val;
        int thisLevelNums = 1;
        int nextLevelNums = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val > maxVal){
                maxVal = node.val;
            }
            thisLevelNums --;
            if (node.left != null){
                queue.offer(node.left);
                nextLevelNums ++;
            }
            if (node.right != null){
                queue.offer(node.right);
                nextLevelNums ++;
            }
            if (thisLevelNums == 0 && !queue.isEmpty()){
                res.add(maxVal);
                thisLevelNums = nextLevelNums;
                nextLevelNums = 0;
                maxVal = queue.element().val;
            }
        }
        res.add(maxVal);
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
