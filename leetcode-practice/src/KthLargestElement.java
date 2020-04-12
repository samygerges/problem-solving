
import java.util.PriorityQueue;

public class KthLargestElement
{
	public static void main(String[] args)
	{
		KthLargestElement k = new KthLargestElement();
		System.out.println(k.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public int findKthLargest(int[] nums, int k)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		for (int i : nums)
		{
			queue.add(i);
		}

		for (int i = 1; i < k; i++)
		{
			queue.poll();
		}
		return queue.peek();
	}
}
