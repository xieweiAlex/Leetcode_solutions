package firstDay;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Alex_Xie on 12/01/2017.

 Find K-th largest element in an array.

 Notice

 You can swap elements in the array

 Have you met this question in a real interview? Yes
 Example
 In array [9,3,2,4,8], the 3rd largest element is 4.

 In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

 https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
 */
public class KthLargest {

    // sort
    public static int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // Priority Queue
    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val: nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }

        }

        return pq.peek();
    }

    // ?? didn't get it
    // The smart approach for this problem is to use the selection algorithm (based on the partion method - the same one as used in quicksort).
    // https://discuss.leetcode.com/topic/14597/solution-explained

    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{9, 3, 2, 4, 8}, 3));
        System.out.println(findKthLargest(new int[]{1, 2, 3, 4, 5}, 1));

        System.out.println(findKthLargest1(new int[]{9, 3, 2, 4, 8}, 3));
        System.out.println(findKthLargest1(new int[]{1, 2, 3, 4, 5}, 1));

    }

}





