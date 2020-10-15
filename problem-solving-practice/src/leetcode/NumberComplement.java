package leetcode;

public class NumberComplement
{
	public static void main(String[] args)
	{
		System.out.println(findComplement(5));
	}

	public static int findComplement(int num)
	{
		StringBuilder result = new StringBuilder();
		for (int i = 31; i >= 0; i--)
		{
			int mask = 1 << i;
			result.append((num & mask) != 0 ? "1" : "0");
		}

		String binary = result.toString();
		int start = 0;
		for (int i = 0; i < binary.length(); i++)
		{
			if (binary.charAt(i) == '1')
			{
				start = i;
				break;
			}
		}
		binary = binary.substring(start);
		int res = 0;
		int x = 0;
		for (int i = binary.length() - 1; i > 0; i--)
		{
			if (binary.charAt(i) == '0')
			{
				res += Math.pow(2, x);
			}
			x++;
		}
		return res;
	}

	public int findComplementOptimized(int n) {
		if(n == 0) {
			return 1;
		}

		int answer = 0;
		int multiplier = 1;

		while(n > 0) {
			int bit = n & 1;
			answer += multiplier * (1 - bit);
			n >>= 1;
			multiplier <<= 1;
		}

		return answer;
	}
}