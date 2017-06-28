package June.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex_Xie on 27/06/2017.

 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 https://leetcode.com/problems/binary-tree-paths/#/description
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            searchBT(root, "", result);
        }
        return result;
    }


    private void searchBT(TreeNode root, String path, List<String> result ) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", result);
        }

    }
}
