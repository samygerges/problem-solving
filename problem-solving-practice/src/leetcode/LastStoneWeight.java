package leetcode;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight
{
    public static void main(String[] args)
    {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    }


    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(queue::add);
        while (queue.size() > 1)
        {
            int x = queue.poll();
            int y = queue.poll();
            if (y < x)
            {
                queue.add(x - y);
            }
        }
        return queue.size() == 1 ? queue.poll() : 0;
    }
}
