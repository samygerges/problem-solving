import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestValsFromLabels
{
    public static void main(String[] args)
    {
        LargestValsFromLabels l = new LargestValsFromLabels();
        System.out.println(l.largestValsFromLabels(new int[] {5, 4, 3, 2, 1}, new int[] {1, 1, 2, 2, 3}, 3, 1));
    }


    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit)
    {
        if (values == null || labels == null)
            return 0;
        List<ValueLabel> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
        {
            list.add(new ValueLabel(values[i], labels[i]));
        }

        Collections.sort(list);
        int sum = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (num_wanted > 0 && i < list.size())
        {
            if (map.getOrDefault(list.get(i).label, 0) < use_limit)
            {
                sum += list.get(i).value;
                map.put(list.get(i).label, map.getOrDefault(list.get(i).label, 0) + 1);
                num_wanted--;
            }

            i++;
        }

        return sum;
    }

    class ValueLabel implements Comparable<ValueLabel>
    {
        public int value;
        public int label;


        public ValueLabel(int value, int label)
        {
            this.value = value;
            this.label = label;
        }


        @Override
        public int compareTo(ValueLabel o)
        {
            return o.value - value;
        }
    }
}
