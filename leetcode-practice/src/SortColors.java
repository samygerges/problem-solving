
public class SortColors
{
    public void sortColors(int[] nums)
    {
        int[] arr = new int[3];

        for (int i : nums)
        {
            arr[i]++;
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i]; j++)
            {
                nums[index++] = i;
            }
        }
    }
}
