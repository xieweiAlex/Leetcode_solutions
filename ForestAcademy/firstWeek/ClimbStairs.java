package ForestAcademy.firstWeek;

/**
 * Created by Alex_Xie on 15/02/2017.


 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {


    public int climbStairs(int n) {

        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;

        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }
}

/*
I still haven't totally understand why m[i] = m[i-1] + m[i-2]
m1 1

m2 2
11, 20,

m 3
// 21, 12, 111

m4
// 211, 121, 1111, 22, 112

*/
