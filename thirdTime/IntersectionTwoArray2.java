package thirdTime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex_Xie on 12/02/2017.
 */
public class IntersectionTwoArray2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
               map.put(num, 1);
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {

                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        IntersectionTwoArray2 obj = new IntersectionTwoArray2();
        int[] array = obj.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int n: array) {
            System.out.println(n);
        }
    }
}
