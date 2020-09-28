import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYe
 * @date 2020/9/24 9:31 下午
 */
public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {

        ArrayList<TreeNode> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        if (start > end){
            ans.add(null);
            return ans;
        }
        if (start == end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTrees = getAns(start, i - 1);
            List<TreeNode> rightTrees = getAns(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
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

