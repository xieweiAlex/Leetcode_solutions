package June.week1;

/**
 * Created by Alex_Xie on 05/06/2017.

 Flatten a binary tree to a fake "linked list" in pre-order traversal.

 Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

 Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

 Have you met this question in a real interview? Yes
 Example
 1
 \
 1          2
 / \          \
 2   5    =>    3
 / \   \          \
 3   4   6          4
 \
 5
 \
 6
 */
public class DFSFlattenTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        // TODO: why need get the right node from node first ???
        TreeNode right = root.right;
        lastNode = root;
        flatten(root.left);
        flatten(right);
    }

    // TODO: There are two other ways I haven't figured out
    // http://www.jiuzhang.com/solution/flatten-binary-tree-to-linked-list/
}
