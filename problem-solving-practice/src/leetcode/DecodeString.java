package leetcode;

import java.util.ArrayDeque;

public class DecodeString
{
	public static void main(String[] args)
	{
		System.out.println(new DecodeString().decodeString("3[a2[c]]"));
	}

	public String decodeString(String s)
	{
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isLetter(s.charAt(i)))
			{
				ans.append(s.charAt(i));
			}
			else if (Character.isDigit(s.charAt(i)))
			{
				int multi = 10;
				int rep = s.charAt(i) - 48;
				int j = i + 1;
				while (j < s.length() && Character.isDigit(s.charAt(j)))
				{
					rep = rep * multi + (s.charAt(j) - 48);
					j++;
				}
				ArrayDeque<Character> stack = new ArrayDeque<>();
				StringBuilder toRepeat = new StringBuilder();
				while (j < s.length())
				{
					toRepeat.append(s.charAt(j));
					if (s.charAt(j) == '[')
					{
						stack.push('[');
					}
					else if (s.charAt(j) == ']')
					{
						stack.pop();
					}
					if (stack.isEmpty())
					{
						break;
					}
					j++;
				}
				String decoded = decodeString(toRepeat.substring(1, toRepeat.length() - 1));
				for (int k = 0; k < rep; k++)
				{
					ans.append(decoded);
				}
				i = j - 1;
			}
		}
		return ans.toString();
	}
}
