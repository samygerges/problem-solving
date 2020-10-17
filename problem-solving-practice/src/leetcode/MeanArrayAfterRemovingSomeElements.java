package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeanArrayAfterRemovingSomeElements
{
	public static void main(String[] args)
	{
		//		System.out.println(
		//			new MeanArrayAfterRemovingSomeElements().trimMean(new int[] { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 }));
		System.out.println(new MeanArrayAfterRemovingSomeElements().trimMean(
			new int[] { 4, 8, 4, 10, 0, 7, 1, 3, 7, 8, 8, 3, 4, 1, 6, 2, 1, 1, 8, 0, 9, 8, 0, 3, 9, 10, 3, 10, 1, 10, 7, 3, 2, 1, 4, 9, 10, 7, 6, 4,
			            0, 8, 5, 1, 2, 1, 6, 2, 5, 0, 7, 10, 9, 10, 3, 7, 10, 5, 8, 5, 7, 6, 7, 6, 10, 9, 5, 10, 5, 5, 7, 2, 10, 7, 7, 8, 2, 0, 1,
			            1 }));
	}

	public double trimMean(int[] arr)
	{
		List<Double> list = new ArrayList<>();
		double sum = 0;
		for (int i : arr)
		{
			list.add(i * 1.0);
		}
		Arrays.sort(arr);
		int toRemove = (int) (5.0 * arr.length / 100.0);
		for(int i = toRemove; i < arr.length - toRemove; i++) {
			sum += arr[i];
		}

		return sum / ((list.size() - toRemove - toRemove) * 1.0);
	}
}
