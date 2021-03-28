package newcoder.jobcode;

/**
 * @author LiuYe
 * @data 2021/3/11
 */
public class NC45 {
    static int i1 = 0;
    static int i2 = 0;
    static int i3 = 0;

    public static void main(String[] args) {

    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] res = new int[3][getSize(root)];
        order(root, res);
        return res;
    }

    private static void order(TreeNode root, int[][] res) {
        if (root == null) {
            return;
        }
        res[0][i1++] = root.val;
        order(root.left,res);
        res[1][i2++] = root.val;
        order(root.right,res);
        res[2][i3++] = root.val;
    }

    private static int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }
}
