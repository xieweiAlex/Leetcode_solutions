package July.week1;

/**
 * Created by Alex_Xie on 05/07/2017.


 "{1,3,{5,2},{{4}}}"  -> 1+3+2(5+2)+3(4) = 30
 "{1,{2,{3}},4}" -> 1 + 2(2) + 3(3) + 4 = 18

 "{-11,{12,{3}},4}" -> -11 + 2*12 + 3(3) + 4 = 26
 "{-11,{12,{-3}},4}" -> -11 + 2*12 + 3(-3) + 4 = 8

 from kiip interview
 */
public class DepthSum {

    public static int depthSum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int sum = 0;
        int sign = 1;
        int eachNum = 0;
        int curlyCount = 0;
        int tempCurly = 0;
        for (char ch: str.toCharArray()) {
            if (ch == '-') {
                sign = -1;
                continue;
            }
            if (ch == '{') {
                curlyCount++;
                continue;
            }
            if (ch == '}') {
                tempCurly++;
                continue;
            }
            if (ch == ',') {
                eachNum *= sign * curlyCount;
                sum += eachNum;

                eachNum = 0;
                sign = 1;
                curlyCount -= tempCurly;
                tempCurly = 0;
                continue;
            }

            int digit = ch - '0';
            eachNum = eachNum * 10 + digit;
        }

        // the last eachNumber hasn't been added to sum
        eachNum *= sign * curlyCount;
        sum += eachNum;

        return sum;
    }


    public static int depthSum1(String str) {
        globalSum = 0;

        depthSum(str, 0);
        return globalSum;
    }


    static int globalSum = 0;
    public static void depthSum(String str, int depth) {
        if (str.length() == 0) return;

        if (str.charAt(0) == ',') {

            depthSum(str.substring(1), depth);
        } else if (str.charAt(0) == '{') {

            depthSum(str.substring(1), depth+1);
        } else if (str.charAt(0) == '}') {

            depthSum(str.substring(1), depth-1);
        } else {
            int idx1 = str.indexOf(",");
            int idx2 = str.indexOf("}");

            if (idx1 < 0 || idx1 > idx2) {
                globalSum += Integer.parseInt(str.substring(0, idx2)) * depth;
                depthSum(str.substring(idx2+1), depth - 1);
            } else {
                globalSum += Integer.parseInt(str.substring(0, idx1)) * depth;
                depthSum(str.substring(idx1+1), depth);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----------final " + depthSum("{1,3,{5,2},{{4}}}"));
        System.out.println("----------final " + depthSum("{1,{2,{3}},4}"));
        System.out.println("----------final: " + depthSum("{-11,{12,{3}},4}"));
        System.out.println("----------final: " + depthSum("{-11,{12,{-3}},4}"));

        System.out.println("--------------------");
        System.out.println("----------second " + depthSum1("{1,3,{5,2},{{4}}}"));
        System.out.println("----------second " + depthSum1("{1,{2,{3}},4}"));
        System.out.println("----------second: " + depthSum1("{-11,{12,{3}},4}"));
        System.out.println("----------second: " + depthSum1("{-11,{12,{-3}},4}"));

    }
}
