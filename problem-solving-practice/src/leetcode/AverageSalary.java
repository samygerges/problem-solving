package leetcode;

public class AverageSalary
{
	public double average(int[] salary)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int sum = 0;
		for (int i : salary)
		{
			min = Math.min(min, i);
			max = Math.max(max, i);
			sum += i;
		}
		if (min == max)
		{
			return (double) (sum - min) / (double) (salary.length - 1);
		}
		return (double) (sum - min - max) / (double) (salary.length - 2);
	}
}
