package hackerrank;

import java.util.Scanner;
import java.util.Stack;

import javafx.util.Pair;

public class MaximumElement
{
	public static void main(String[] args)
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Pair<Long, Long>> stack = new Stack<>();
		for (int i = 0; i < n; i++)
		{
			int op = in.nextInt();
			if (op == 1)
			{
				long x = in.nextLong();
				long max = x;
				if (!stack.isEmpty())
				{
					max = Math.max(stack.peek().getValue(), x);
				}
				stack.push(new Pair<>(x, max));
			}
			if (op == 2)
			{
				stack.pop();
			}
			if (op == 3)
			{
				System.out.println(stack.peek().getValue());
			}
		}
		in.close();
	}
}
