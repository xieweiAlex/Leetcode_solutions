package ForestAcademy.week1;

/**
 * Created by Alex_Xie on 13/02/2017.
 */
public class ToHex {

    public String toHex(int num) {
        if (num == 0) return "0";

        Character[] array = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while (num != 0 && result.length() < 8){
            result = array[num & 15] + result;
            num = num >> 4;
        }
        return result;
    }


    public static void main(String[] args) {
        ToHex obj = new ToHex();
        System.out.println(obj.toHex(12));

    }

}




