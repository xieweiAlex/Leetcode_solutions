package SecondDay;
/**
 * Created by Alex_Xie on 13/01/2017.
 *
 *
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 */
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left, 1), getDepth(root.right, 1));
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        if (node.left != null && node.right == null) {

            return getDepth(node.left, depth);
        } else if (node.right != null && node.left == null) {

            return getDepth(node.right, depth);
        } else {
            return Math.max(getDepth(node.left, depth), getDepth(node.right, depth));
        }
    }

    // selection
    public int maxDepth2(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right))+1;
    }

    public static void main(String[] args) {

    }


}


