package July.week1;

/**
 * Created by Alex_Xie on 07/07/2017.
 Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.
 Note: Time complexity should be O(height of tree).

 https://leetcode.com/problems/delete-node-in-a-bst/#/description
 */
public class DeleteNodeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // root.val == key

            if (root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // root.left and roo.right both have value
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            // delete the minNode on the right side
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }




}
