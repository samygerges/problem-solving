
public class LisaWorkbook
{
    public static void main(String[] args)
    {
        //System.out.println(workbook(5, 3, new int[] {4, 2, 6, 1, 10}));
        System.out.println(workbook(10, 5, new int[] {3, 8, 15, 11, 14, 1, 9, 2, 24, 31}));
    }


    static int workbook(int n, int k, int[] arr)
    {
        int count = 0;

        int page = 1;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 1; j <= arr[i]; j++)
            {
                if (j == page)
                {
                    count++;
                }
                if (j % k == 0 && j + 1 <= arr[i])
                {
                    page++;
                }
            }
            page++;
        }

        return count;
    }
}
