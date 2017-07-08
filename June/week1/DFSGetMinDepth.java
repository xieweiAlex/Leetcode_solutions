package June.week1;

/**
 * Created by Alex_Xie on 05/06/2017.
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 Have you met this question in a real interview? Yes
 Example
 Given a binary tree as follow:

 1
 / \
 2   3
 / \
 4   5
 The minimum depth is 2.
 https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description

 http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/#
 http://www.jiuzhang.com/solution/minimum-depth-of-binary-tree/

 */
public class DFSGetMinDepth {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        // TODO: to fix
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

}
