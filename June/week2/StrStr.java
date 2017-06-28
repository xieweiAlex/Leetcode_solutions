package June.week2;

/**
 * Created by Alex_Xie on 07/06/2017.
 For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 If target does not exist in source, just return -1.

 Example
 If source = "source" and target = "target", return -1.

 If source = "abcdabcdefg" and target = "bcd", return 1.

 http://www.lintcode.com/en/problem/strstr/
 */
public class StrStr {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        // TODO: why (+1) this one works instead of crash?
        for (int i = 0; i < source.length() - target.length() +1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }
}
