package beforeApril.firstDay.ForestAcademy.week2;

/**
 * Created by Alex_Xie on 26/02/2017.
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

0 11
0 11
- ---
 110

 https://leetcode.com/problems/add-binary/?tab=Description
 */
public class AddBinary {

    public String addBinary1(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) +
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) +
                    carry;

            // only difference
            sb.append(Integer.toString(sum & 1));
            carry = (sum >> 1) & 1;
        }

        return sb.reverse().toString();
    }


    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

}
