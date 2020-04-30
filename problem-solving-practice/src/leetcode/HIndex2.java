package leetcode;

public class HIndex2
{
    public static void main(String[] args)
    {
        HIndex2 h = new HIndex2();
        System.out.println(h.hIndex(new int[] {0, 1, 3, 5, 6}));
    }


    public int hIndex(int[] citations)
    {
        int n = citations.length;

        if (n == 0)
            return 0;
        if (citations[0] >= n)
            return n;
        if (citations[n - 1] == 0)
            return 0;

        return binarySearch(citations, 0, n - 1, n);
    }


    private int binarySearch(int[] citations, int left, int right, int n)
    {
        int mid = 0;
        while (left < right)
        {
            mid = left + (right - left) / 2;
            if (n - mid < citations[mid])
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        if (citations[left - 1] == n - left + 1)
            left--;
        return n - left;
    }
}
