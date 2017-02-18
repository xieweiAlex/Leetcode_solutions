package ForestAcademy;

/**
 * Created by Alex_Xie on 17/02/2017.

 Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (checkAll9(digits)) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = 0;
            }

            logArray(newDigits);
            return newDigits;
        }

        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            // plus one
            if (i == digits.length-1) {
                digits[i] += 1;
            }

            int num = digits[i];
            if (num + carry > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = num + carry;
                carry = 0;
            }
        }

        logArray(digits);

        return digits;
    }

    private boolean checkAll9(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                return false;
            }
        }
       return true;
    }

    private void logArray(int[] digits) {
        // log
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }

        System.out.println("");
        System.out.println("----");
    }


    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
//        System.out.println(obj.plusOne(new int[]{1, 2, 3}));
//        System.out.println(obj.plusOne(new int[]{1, 2, 9}));
//        System.out.println(obj.plusOne(new int[]{1, 2, 9, 9}));
//        System.out.println(obj.plusOne(new int[]{9, 9, 9, 9, 9}));
        System.out.println(obj.plusOne1(new int[]{1, 2, 3}));
        System.out.println(obj.plusOne1(new int[]{1, 2, 9}));
        System.out.println(obj.plusOne1(new int[]{1, 2, 9, 9}));
        System.out.println(obj.plusOne1(new int[]{9, 9, 9, 9, 9}));

    }

}
