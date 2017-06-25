package beforeApril.firstDay.SecondDay;

/**
 * Created by Alex_Xie on 13/01/2017.

 Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 // [3,9,20,null,null,15,7]

 */
public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        } else {
            res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }


    public static void main(String[] args) {
    }

}

