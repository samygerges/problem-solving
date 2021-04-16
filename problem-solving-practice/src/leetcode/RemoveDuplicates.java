package leetcode;

import java.util.ArrayDeque;

import javafx.util.Pair;

public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		System.out.println(new RemoveDuplicates().removeDuplicates("abcd", 2));
	}

	public String removeDuplicates(String s, int k)
	{
		ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++)
		{
			// merge
			if (!stack.isEmpty() && stack.getLast().getKey().charValue() == s.charAt(i))
			{
				Pair<Character, Integer> last = stack.removeLast();
				stack.addLast(new Pair<>(s.charAt(i), last.getValue() + 1));
			}
			else
			{
				stack.addLast(new Pair<>(s.charAt(i), 1));
			}
			if (stack.getLast().getValue() == k)
			{
				stack.removeLast();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
		{
			for (int i = 0; i < stack.getFirst().getValue(); i++)
			{
				sb.append(stack.getFirst().getKey());
			}
			stack.removeFirst();
		}
		return sb.toString();
	}
}
