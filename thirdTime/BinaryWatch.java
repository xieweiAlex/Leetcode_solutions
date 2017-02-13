package thirdTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex_Xie on 12/02/2017.
 */
public class BinaryWatch {

    public List<String> readBinaryWatch1(int num) {
        ArrayList<String> result = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
//                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    System.out.println("j is: " + j);
                    System.out.println("bitCount j is: " + Integer.bitCount(j));
//                if (i + j == num) {
//                    result.add(String.format("%d:%02d", i, j));
//                }
            }
//        }

        return result;
    }



    // 8 4 2 1
    // 32 16 8 4 2 1
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1};
        int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};

        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        BinaryWatch obj = new BinaryWatch();
        System.out.println(obj.readBinaryWatch1(1));

    }


}
