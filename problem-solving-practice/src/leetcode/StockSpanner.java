package leetcode;

import java.util.Stack;

public class StockSpanner
{
	public static void main(String[] args)
	{
		StockSpanner stockSpanner = new StockSpanner();
		System.out.println(stockSpanner.next(100));
		System.out.println(stockSpanner.next(80));
		System.out.println(stockSpanner.next(60));
		System.out.println(stockSpanner.next(70));
		System.out.println(stockSpanner.next(60));
		System.out.println(stockSpanner.next(75));
		System.out.println(stockSpanner.next(85));

	}

	private Stack<Integer> stack = null;
	private int[] stock = null;
	private int index;

	public StockSpanner()
	{
		index = 0;
		stock = new int[100001];
		stack = new Stack<>();
	}

	public int next(int price)
	{
		stock[index++] = price;
		while (!stack.empty() && stock[stack.peek()] <= stock[index - 1])
		{
			stack.pop();
		}
		int ans = stack.isEmpty() ? index : index - 1 - stack.peek();
		stack.push(index - 1);
		return ans;
	}
}

/**
 * Your StockSpanner object will be instantiated and called as such: StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */
