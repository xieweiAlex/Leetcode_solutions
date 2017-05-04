package ForestAcademy.firstWeek;

/**
 * Created by Alex_Xie on 14/02/2017.

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition_null {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int middle = (low + high)/2;
            if (middle == target) {
                return middle;
            } else if(middle > target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return low;
    }


   public static void main(String[] args) {
       SearchInsertPosition_null obj = new SearchInsertPosition_null();
       System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 5));
       System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 2));
       System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 7));
       System.out.println(obj.searchInsert(new int[]{1,3,5,6}, 0));

   }

}
