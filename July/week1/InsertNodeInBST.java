package July.week1;

/**
 * Created by Alex_Xie on 07/07/2017.

 http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
 */
public class InsertNodeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null){
            return node;
        }

        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }

        return root;
    }

}
