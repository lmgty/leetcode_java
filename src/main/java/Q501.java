import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q501 {
    private List<Integer> res = new ArrayList<>();
    private int currentElement, currentCount, maxCount;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(Arrays.toString(new Q501().findMode(root)));

    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mode[i] = res.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        compareHelper(root.val);
        dfs(root.right);
    }

    private void compareHelper(int val) {
        if (currentElement == val) {
            currentCount++;
        } else {
            currentElement = val;
            currentCount = 1;
        }
        if (currentCount == maxCount) {
            res.add(currentElement);
        } else if (currentCount > maxCount) {
            res.clear();
            res.add(currentElement);
            maxCount = currentCount;
        }


//        if (currentElement != val) {
//            if (currentCount == maxCount) {
//                res.add(currentElement);
//            } else if (currentCount > maxCount) {
//                res.clear();
//                res.add(currentElement);
//                maxCount = currentCount;
//            }
//            currentElement = val;
//            currentCount = 1;
//        }else {
//            currentCount ++;
//        }
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
