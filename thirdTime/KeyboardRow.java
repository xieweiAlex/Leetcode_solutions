package thirdTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Alex_Xie on 12/02/2017.
 */
public class KeyboardRow {

    public static String[] findWords2(String[] words){
        String s1="qwertyuiop",s2="asdfghjkl",s3="zxcvbnm";
        List<String> list = new ArrayList<String>();
        int count1=0,count2=0,count3=0;
        for(int i=0;i!=words.length;i++){
            for(int j=0;j!=words[i].length();j++){
                if(s1.indexOf(words[i].toLowerCase().charAt(j))!=-1 ){
                    count1++;
                }
                if(s2.indexOf(words[i].toLowerCase().charAt(j))!=-1){
                    count2++;
                }
                if(s3.indexOf(words[i].toLowerCase().charAt(j))!=-1){
                    count3++;
                }
            }
            if(count1==words[i].length() || count2==words[i].length() || count3==words[i].length()){
                list.add(words[i]);
            }
            count1=0;
            count2=0;
            count3=0;
        }

        return list.toArray(new String[0]);
    }

    public String[] findWords1(String[] words) {

        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);

    }

    public String[] findWords(String[] words) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        Map<Character, Character> map3 = new HashMap<>();
        Character[] arr1 = new Character[]{'q', 'w', 'e', 't', 'y', 'u', 'i', 'o', 'r', 'p'};
        Character[] arr2 = new Character[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        Character[] arr3 = new Character[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        for (Character str: arr1) {
            map1.put(str, str);
        }
        for (Character str: arr2) {
            map2.put(str, str);
        }
        for (Character str: arr3) {
            map3.put(str, str);
        }

        for (String str: words) {

        }



        return null;
    }

    public static void main(String[] args) {

    }
}
