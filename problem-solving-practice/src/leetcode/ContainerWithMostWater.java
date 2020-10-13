package leetcode;

public class ContainerWithMostWater
{
	public static void main(String[] args)
	{
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 2, 3, 10, 5, 7, 8, 9 })); // 36
	}

	public int maxArea(int[] height)
	{
		int water = 0;
		for (int i = 0; i < height.length; i++)
		{
			for (int j = i + 1; j < height.length; j++)
			{
				water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
			}
		}
		return water;
	}
}
