import java.util.*;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q257 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        binaryTreePaths(root);


    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private static void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(pathSB.toString());
        } else {
            pathSB.append("->");
            dfs(root.left, pathSB.toString(), paths);
            dfs(root.right, pathSB.toString(), paths);
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
