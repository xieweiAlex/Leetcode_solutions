package June.week4;

import java.util.Stack;

/**
 * Created by Alex_Xie on 19/06/2017.
 *
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ? k ? BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 */

public class BSTKthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        // TODO: why not count k == count as the target??
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1); // 1 is counted as current node
        }

        return root.val;
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // DFS in-order recursive:
    private static int number = 0;
    private static int count = 0;
    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        count--;

        if (count == 0) {
            number = node.val;
            return;
        }

        if (node.right != null) {
            helper(node.right);
        }
    }

    // DFS in-order iterative:
    public int kthSmallest22(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

        while (k != 0) {
            TreeNode node = stack.pop();
            k--;

            if (k == 0) return node.val;
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }


}
