package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch
{
	public static void main(String[] args)
	{
		System.out.println(new BinaryWatch().readBinaryWatch(2));
	}

	public List<String> readBinaryWatch(int num) {
		Set<String> answer = new HashSet<>();
		int[] arr = new int[10];
		backtrack(num, 0, arr, answer);
		return new ArrayList<>(answer);
	}

	private void backtrack(int num, int current, int[] arr, Set<String> answer) {
		if(current == num) {
			int hour = 1*arr[0] + 2*arr[1] + 4*arr[2] + 8*arr[3];
			int min = 1*arr[4] + 2*arr[5] + 4*arr[6] + 8*arr[7] + 16*arr[8] + 32*arr[9];
			if(hour < 12 && min < 60) {
				String ans = hour + ":" + ((min < 10) ? "0" + min : min);
				answer.add(ans);
			}
			return;
		}

		for(int i = 0; i < 10; i++) {
			if(arr[i] != 1)
			{
				arr[i] = 1;
				backtrack(num, current + 1, arr, answer);
				arr[i] = 0;
			}
		}
	}
}
