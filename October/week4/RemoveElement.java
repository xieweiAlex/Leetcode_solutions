package October.week4;

/*

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }

        return begin;
    }


    public int removeElement1(int A[], int n, int elem) {
        int i = 0;
        while (i < n) {
            if (A[i] == elem) {
                A[i] = A[n - 1];
                n--;
            }
            else
                i++;
        }
        return n;
    }
}


