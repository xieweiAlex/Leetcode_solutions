package ForestAcademy;

/**
 * Created by Alex_Xie on 19/02/2017.

 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 https://leetcode.com/problems/minimum-depth-of-binary-tree/?tab=Description
 */

public class MinDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {

           return 1 + minDepth(root.left);
        } else if(root.left != null && root.right != null) {

            int leftNum = 1 + minDepth(root.left);
            int rightNum = 1 + minDepth(root.right);
        }

        // minLeft, minRight
        // return Math.min(minLeft, minRight)
        return 0;
    }

    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    public static int minDepth2(TreeNode root) {
        if (root == null)	return 0;
        if (root.left == null)	return minDepth2(root.right) + 1;
        if (root.right == null) return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

}




