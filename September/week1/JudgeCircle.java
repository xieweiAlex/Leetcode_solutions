package September.week1;

/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

https://leetcode.com/problems/judge-route-circle/description/
* */

public class JudgeCircle {

    public boolean judgeCircle(String moves) {
       int x = 0;
       int y = 0;
       for (char ch: moves.toCharArray()) {
           if (ch == 'U') y++;
           else if (ch == 'D') y--;
           else if (ch == 'L') x--;
           else if (ch == 'R') x++;
       }

       return x == 0 && y == 0;
    }

}
