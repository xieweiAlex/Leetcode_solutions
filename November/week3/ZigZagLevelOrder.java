package November.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

 * explain:
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
Seen this question in a real interview before?   Yes
 * url:
 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * solution:

*/
public class ZigZagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> bigList = new ArrayList<>();
        travel(root, bigList, 0);
        return bigList;
    }

    private void travel(TreeNode curr, List<List<Integer>> bigList, int level) {
        if (curr == null) return;

        if (bigList.size() == level) {
            List<Integer> list = new LinkedList<>();
            bigList.add(list);
        }

        List list = bigList.get(level);
        if (level %2 == 0) {
            list.add(curr.val);
        } else {
            list.add(0, curr.val);
        }

        travel(curr.left, bigList, level + 1);
        travel(curr.right, bigList, level + 1);
    }

    // BFS
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Boolean order = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if ((order == true)) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(list);
            order = !order;
        }

        return res;
    }

}
