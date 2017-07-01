package June.week5;

/**
 * Created by Alex_Xie on 29/06/2017.
 */
public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Integer max = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return max;
    }

    private Integer maxDepth(TreeNode root) {
        if (root == null) return 0;

        Integer left = maxDepth(root.left);
        Integer right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

}
