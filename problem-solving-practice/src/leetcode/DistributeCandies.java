package leetcode;

public class DistributeCandies
{
	public static void main(String[] args)
	{
		System.out.println(new DistributeCandies().distributeCandies(10, 3));
	}

	public int[] distributeCandies(int candies, int num_people) {
		int[] arr = new int[num_people];

		int round = 0;
		int i = 0;
		while(candies > 0) {
			int num = round + (i + 1);
			if(candies >=  num) {
				candies -= num;
			} else {
				num = candies;
				candies = 0;
			}
			arr[i] += num;
			i++;
			if(i == num_people) {
				round += num_people;
				i = 0;
			}
		}
		return arr;
	}
}
