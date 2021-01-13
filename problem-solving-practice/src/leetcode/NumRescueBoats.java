package leetcode;

import java.util.Arrays;

public class NumRescueBoats
{
	public static void main(String[] args)
	{
		System.out.println(new NumRescueBoats().numRescueBoats(new int[] { 3, 2, 2, 3, 2 }, 6));
		System.out.println(new NumRescueBoats().numRescueBoats(new int[] { 1, 2 }, 3));
		System.out.println(new NumRescueBoats().numRescueBoats(new int[] { 3, 5, 3, 4 }, 5));
	}

	public int numRescueBoats(int[] people, int limit)
	{
		Arrays.sort(people);
		int l = 0;
		int r = people.length - 1;
		int boats = 0;
		while (l <= r)
		{
			int count = people[r];
			int n = 1;
			r--;
			while (n < 2 && r >= 0 && r >= l && count + people[r] <= limit)
			{
				count += people[r];
				r--;
				n++;
			}
			while (n < 2 && l < people.length && l <= r && count + people[l] <= limit)
			{
				count += people[l];
				l++;
				n++;
			}
			boats++;
		}
		return boats;
	}
}
