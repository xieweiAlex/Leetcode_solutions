package June.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alex_Xie on 05/06/2017.
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 Have you met this question in a real interview? Yes
 Example
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

 http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 */
public class BFSLevelOrder {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
