import java.util.List;

/**
 * @author LiuYe
 * @data 2020/11/24
 */
public class Q559 {
    private int maxDepth = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxSonDepth = 0;
        for (Node node: root.children) {
            int sonDepth = maxDepth(node);
            if (sonDepth > maxSonDepth) {
                maxSonDepth = sonDepth;
            }
        }
        return maxSonDepth + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}


