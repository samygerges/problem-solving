package hackerrank;

import java.util.Arrays;

public class HackerlandRadioTransmitters
{
	public static void main(String[] args)
	{
		System.out.println(hackerlandRadioTransmitters(new int[] { 7, 2, 4, 6, 5, 9, 12, 11 }, 2));
	}

	static int hackerlandRadioTransmitters(int[] x, int k)
	{
		Arrays.sort(x);
		int count = 0;

		for (int i = 0; i < x.length; i++)
		{
			count++;
			int j = i + 1;
			while (j < x.length && x[j] <= x[i] + k)
			{
				j++;
			}
			j--;
			int kk = j + 1;
			while (kk < x.length && x[j] + k >= x[kk])
			{
				kk++;
			}
			i = kk - 1;
		}

		return count;
	}
}
