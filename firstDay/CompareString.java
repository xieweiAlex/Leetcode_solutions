package firstDay;

/**
 * Created by Alex_Xie on 12/01/2017.
 *
 *
 Compare two strings A and B, determine whether A contains all of the characters in B.

 The characters in string A and B are all Upper Case letters.

 Notice
 The characters of B in A are not necessary continuous or ordered.

 Example
 For A = "ABCD", B = "ACD", return true.

 For A = "ABCD", B = "AABC", return false.
 *
 */
public class CompareString {
   public static boolean compareStrings(String A, String B) {
       int nums[] = new int[26];
       for (Character ch: A.toCharArray()) {
           int num = nums[ch - 'A'];
           nums[ch - 'A'] = num +1;
       }

       for (Character ch: B.toCharArray()) {
           if (nums[ch - 'A'] <= 0) {
               return false;
           }
       }

        return true;
   }


   public static void main(String[] args) {
       System.out.println(compareStrings("ABCD", "ACD"));
       System.out.println(compareStrings("ABCDEFG", "ACC"));
   }

}
