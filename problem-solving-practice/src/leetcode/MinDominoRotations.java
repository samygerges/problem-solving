package leetcode;
public class MinDominoRotations
{
    public static void main(String[] args)
    {
        MinDominoRotations m = new MinDominoRotations();
        System.out.println(m.minDominoRotations(new int[] {1, 2, 3, 4, 6}, new int[] {6, 6, 6, 6, 5}));
    }


    public int minDominoRotations(int[] A, int[] B)
    {
        int[] arr1 = new int[6];
        int[] arr2 = new int[6];
        int n = A.length;
        int element = -1;
        for (int i = 0; i < B.length; i++)
        {
            if (A[i] == B[i])
            {
                n--;
                if (element == -1)
                {
                    element = A[i];
                }
                else if (element != A[i])
                {
                    return -1;
                }
                continue;
            }

            arr1[A[i] - 1]++;
            arr2[B[i] - 1]++;

            if (arr1[A[i] - 1] == A.length || arr2[B[i] - 1] == B.length)
            {
                return 0;
            }
        }

        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] + arr2[i] >= n && (element == -1 || element == i + 1))
            {
                return Math.min(arr1[i], arr2[i]);
            }
        }
        return -1;
    }
}
