package April;

import java.util.Stack;

/**
 * Created by Alex_Xie on 14/04/2017.
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 https://leetcode.com/problems/min-stack/#/description
 */
public class MinStack {

    long min;
    Stack<Long> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            // save the difference
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int)(top + min);
        } else {
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static void main(String[] args) {

    }

}
