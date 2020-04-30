package leetcode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AsteroidCollision
{
    public int[] asteroidCollision(int[] asteroids)
    {
        List<Integer> list = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
        int i = 0;
        while (i < list.size() - 1 && list.size() > 1)
        {
            if (list.get(i) > 0 && list.get(i + 1) < 0)
            {
                if (Math.abs(list.get(i)) > Math.abs(list.get(i + 1)))
                {
                    list.remove(i + 1);
                }
                else
                {
                    if (Math.abs(list.get(i)) < Math.abs(list.get(i + 1)))
                    {
                        list.remove(i);
                    }
                    else
                    {
                        list.remove(i);
                        list.remove(i);
                    }
                    if (i > 0)
                        i--;
                }
            }
            else
            {
                i++;
            }
        }
        return list.stream().mapToInt(integer -> integer).toArray();
    }
}
