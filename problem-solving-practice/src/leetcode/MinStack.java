package leetcode;
import java.util.Stack;

import javafx.util.Pair;

public class MinStack
{
    private Stack<Pair<Integer, Integer>> stack;


    /** initialize your data structure here. */
    public MinStack()
    {
        stack = new Stack<>();
    }


    public void push(int x)
    {
        if (stack.isEmpty())
        {
            stack.push(new Pair<Integer, Integer>(x, x));
        }
        else
        {
            int min = stack.peek().getValue();
            stack.push(new Pair<Integer, Integer>(x, Math.min(x, min)));
        }
    }


    public void pop()
    {
        stack.pop();
    }


    public int top()
    {
        return stack.peek().getKey();
    }


    public int getMin()
    {
        return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
