package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks
{
	public static void main(String[] args)
	{
		Arrays.stream(cutTheSticks(new int[] { 1, 2, 3, 4, 3, 3, 2, 1 })).forEach(System.out::print);
	}

	static int[] cutTheSticks(int[] arr)
	{
		List<Integer> list = new ArrayList<>();
		Arrays.sort(arr);
		int index = 0;
		for (int i = 0; i < arr.length; i++)
		{
			index = i;
			list.add(arr.length - index);
			while (index + 1 < arr.length && arr[index] == arr[index + 1])
			{
				index++;
			}
			i = index;
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
