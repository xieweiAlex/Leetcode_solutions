import java.util.Arrays;

/**
 * Created by Alex_Xie on 12/01/2017.
 *
 Given a unsorted array with integers, find the median of it.

 A median is the middle number of the array after it is sorted.

 If there are even numbers in the array, return the N/2-th number after sorted.

 Example
 Given [4, 5, 1, 2, 3], return 3.

 Given [7, 9, 4, 5], return 5.

 */
public class Median {
    public static int median(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        if (nums.length %2 == 0) {
            return nums[nums.length /2 -1];
        }

        return nums[nums.length/2 + 1 -1];
    }

    public static void main(String[] args) {
        System.out.println(median(new int[]{4, 5, 1, 2, 3}));
        System.out.println(median(new int[]{7, 9, 4, 5}));

    }
}
