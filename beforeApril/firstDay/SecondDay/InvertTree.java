package beforeApril.firstDay.SecondDay;

/**
 * Created by Alex_Xie on 14/01/2017.
 *
 Invert a binary tree.
 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:
 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;

        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
           return null;
        }
        // don't use right because right has been changed when using it.
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);

        return root;
    }

}
