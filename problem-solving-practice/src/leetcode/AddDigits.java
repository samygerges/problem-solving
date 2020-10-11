package leetcode;

public class AddDigits
{
	public static void main(String[] args)
	{
		System.out.println(new AddDigits().addDigits(38));
	}
	public int addDigits(int num)
	{
		while (true)
		{
			int sum = 0;
			while (num > 0)
			{
				sum += (num % 10);
				num = num / 10;
			}
			if(sum < 10) {
				return sum;
			}
			num = sum;
		}
	}
}
