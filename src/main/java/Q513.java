import java.util.*;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q513 {
    private List<Integer> res = new ArrayList<>();
    private int currentElement, currentCount, maxCount;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(5);
//        root.right.right.right = new TreeNode(7);


        System.out.println(new Q513().findBottomLeftValue(root));

    }

    public int findBottomLeftValue(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        int leftVal = root.val;
        int thisLevelNums = 1;
        int nextLevelNums = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
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
                thisLevelNums = nextLevelNums;
                nextLevelNums = 0;
                leftVal = queue.element().val;
            }
        }

        return leftVal;
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
