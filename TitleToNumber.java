/**
 * Created by Alex_Xie on 12/01/2017.
 *
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28


 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */

public class TitleToNumber {
    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }


    public static void main(String[] args) {
//        System.out.println("result is: " + titleToNumber("A") );
//        System.out.println("result is: " + titleToNumber("AA") );
//        System.out.println("result is: " + titleToNumber("AB") );

        System.out.println("result is: " + convertToTitle(2) );
        System.out.println("result is: " + convertToTitle(26) );
        System.out.println("result is: " + convertToTitle(28) );
    }
}

