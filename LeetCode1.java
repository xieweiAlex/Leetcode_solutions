import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 31/12/2016.
 */
public class LeetCode1 {

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int res = 0;
        while(xor!=0) {
            res+= xor & 1;
            xor >>= 1;
        }
        System.out.println(res);
        return res;
    }

    public boolean anagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch: s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }

        }

        for (Character ch: t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            int num = map.get(ch);
            map.put(ch, num-1);
        }

        for (Character ch: map.keySet()) {
            Integer num = map.get(ch);
            if (num != 0) {
                return false;
            }
        }

       return true;
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        LeetCode1 ob = new LeetCode1();
//        ob.hammingDistance(1, 5);

        System.out.println(ob.anagram("abcd", "bdca"));

    }



}
