import java.util.*;

/**
 * @author LiuYe
 * @date 2020/10/13 8:23 下午
 */
public class BinaryTreeLevelOrderTraversalII107 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrderBottom(root);

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> treeNodesQueue = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();

        int numsOfThisLevel = 1;
        int numsOfSonLevel = 0;

        treeNodesQueue.offer(root);
        while (!treeNodesQueue.isEmpty()){
            TreeNode node = treeNodesQueue.poll();
            nums.add(node.val);
            if (node.left != null){
                treeNodesQueue.offer(node.left);
                numsOfSonLevel++;
            }
            if(node.right != null){
                treeNodesQueue.offer(node.right);
                numsOfSonLevel++;
            }
            if (nums.size() == numsOfThisLevel){
                ans.add(nums);
                nums = new ArrayList<>();
                numsOfThisLevel = numsOfSonLevel;
                numsOfSonLevel = 0;
            }
        }
        Collections.reverse(ans);
        return ans;
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
