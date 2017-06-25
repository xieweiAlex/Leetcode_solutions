package beforeApril.firstDay.ForestAcademy.week1;

import java.util.Stack;

/**
 * Created by Alex_Xie on 19/02/2017.
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 https://leetcode.com/problems/valid-parentheses/?tab=Description
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if(ch == '{') {
                stack.push('}');
            } else if(ch == '[') {
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {


    }


}
