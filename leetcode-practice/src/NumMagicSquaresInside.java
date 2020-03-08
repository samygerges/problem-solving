import java.util.HashSet;
import java.util.Set;

public class NumMagicSquaresInside
{
    public static void main(String[] args)
    {
        NumMagicSquaresInside n = new NumMagicSquaresInside();
        System.out.println(n.numMagicSquaresInside(new int[][] {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }


    public int numMagicSquaresInside(int[][] grid)
    {
        int count = 0;

        for (int i = 0; i <= grid.length - 3; i++)
        {
            for (int j = 0; j <= grid[i].length - 3; j++)
            {
                if (grid[i + 1][j + 1] != 5)
                    continue;

                if (grid[i][j] > 9
                    || grid[i][j + 1] > 9 || grid[i][j + 2] > 9 || grid[i + 1][j] > 9 || grid[i + 1][j + 1] > 9 || grid[i + 1][j + 2] > 9 || grid[i + 2][j] > 9
                    || grid[i + 2][j + 1] > 9 || grid[i + 2][j + 2] > 9)
                    continue;
                if (grid[i][j] < 1
                    || grid[i][j + 1] < 1 || grid[i][j + 2] < 1 || grid[i + 1][j] < 1 || grid[i + 1][j + 1] < 1 || grid[i + 1][j + 2] < 1 || grid[i + 2][j] < 1
                    || grid[i + 2][j + 1] < 1 || grid[i + 2][j + 2] < 1)
                    continue;

                Set<Integer> set = new HashSet<>();
                int row = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int col = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                int diagonal1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int diagonal2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

                set.add(grid[i][j]);
                set.add(grid[i + 1][j]);
                set.add(grid[i + 2][j]);
                set.add(grid[i][j + 1]);
                set.add(grid[i + 1][j + 1]);
                set.add(grid[i + 2][j + 1]);
                set.add(grid[i][j + 2]);
                set.add(grid[i + 1][j + 2]);
                set.add(grid[i + 2][j + 2]);
                if (row == col && col == diagonal1 && row == diagonal2 && set.size() == 9)
                {
                    count++;
                }
            }
        }

        return count;
    }
}
