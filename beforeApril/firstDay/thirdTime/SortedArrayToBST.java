package beforeApril.firstDay.thirdTime;

/**
 * Created by Alex_Xie on 13/02/2017.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }

        int middle = (low + high) / 2;
        TreeNode node = new TreeNode(num[middle]);
        node.left = helper(num, low, middle-1);
        node.right = helper(num, middle+1,  high);
        return node;
    }

    public static void main(String[] args) {

    }

}
