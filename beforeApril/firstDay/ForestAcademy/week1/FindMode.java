package beforeApril.firstDay.ForestAcademy.week1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Alex_Xie on 15/02/2017.

 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].
 */
public class FindMode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer>map = new HashMap<>();
    int max;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        inorder(root);

        List<Integer> list =  map.keySet().stream()
                .filter(key -> map.get(key) == max)
                .collect(Collectors.toList());

        int[] array = list.stream().mapToInt(i->i).toArray();

        return array;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(max, map.get(node.val));
        if (node.right != null) inorder(node.right);
    }




}
