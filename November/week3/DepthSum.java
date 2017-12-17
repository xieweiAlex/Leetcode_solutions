package November.week3;
import java.util.LinkedList;
import java.util.List;

/*

 * explain:
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)


 * url:
https://leetcode.com/problems/nested-list-weight-sum/description/
 * solution:

*/
public class DepthSum {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
//        // Constructor initializes an empty nested list.
//        public NestedInteger();
//
//        // Constructor initializes a single integer.
//        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        int level = 1, result = 0;
        while (nestedList.size() != 0) {
           List<NestedInteger> next = new LinkedList<>();
           for (NestedInteger nInt: nestedList) {
               if (nInt.isInteger()) {
                   result += nInt.getInteger() * level;
               } else {
                   next.addAll(nInt.getList());
               }
           }
           level++;
           nestedList = next;
        }

        return result;
    }

    // DFS
    public int depthSum1(List<NestedInteger> nestedList) {

        return DFS(nestedList, 1);
    }

    private int DFS(List<NestedInteger> list, int depth) {
        int result = 0;
        for (NestedInteger e: list) {
            if (e.isInteger()) {
                result += e.getInteger() * depth;
            } else {
                result += DFS(e.getList(), depth + 1);
            }
        }
        return result;
    }

}
