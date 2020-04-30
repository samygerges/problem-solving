package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueensThatCanAttackTheKing
{
    public static void main(String[] args)
    {
        QueensThatCanAttackTheKing q = new QueensThatCanAttackTheKing();
        System.out.println(
            q.queensAttacktheKing(
                new int[][] {
                    {5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5},
                    {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}},
                new int[] {3, 4}));
    }


    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king)
    {
        List<Position> queenPositions = new ArrayList<>();
        List<Position> result = new ArrayList<>();
        for (int[] pos : queens)
        {
            queenPositions.add(new Position(pos[0], pos[1]));
        }
        result.addAll(getAttakingQueensRow(queenPositions, king));
        result.addAll(getAttakingQueensCol(queenPositions, king));
        result.addAll(getAttakingQueensDiagonal(queenPositions, king));

        List<List<Integer>> output = new ArrayList<>();
        for (Position position : result)
        {
            List<Integer> queen = new ArrayList<>();
            queen.add(position.row);
            queen.add(position.col);
            output.add(queen);
        }

        return output;
    }


    private List<Position> getAttakingQueensRow(List<Position> queenPosition, int[] king)
    {
        List<Position> attackingQueens = new ArrayList<>();
        for (Position position : queenPosition)
        {
            if (position.row == king[0])
            {
                position.diff = position.col - king[1];
                attackingQueens.add(position);
            }
        }
        return removeBlockedQueens(attackingQueens, true);
    }


    private List<Position> getAttakingQueensCol(List<Position> queenPosition, int[] king)
    {
        List<Position> attackingQueens = new ArrayList<>();
        for (Position position : queenPosition)
        {
            if (position.col == king[1])
            {
                position.diff = position.row - king[0];
                attackingQueens.add(position);
            }
        }
        return removeBlockedQueens(attackingQueens, true);
    }


    private List<Position> getAttakingQueensDiagonal(List<Position> queenPosition, int[] king)
    {
        List<Position> attackingQueens = new ArrayList<>();
        for (Position position : queenPosition)
        {
            int diffRow = position.row - king[0];
            int diffCol = position.col - king[1];
            if (diffRow == diffCol || -1 * diffRow == diffCol)
            {
                position.diff = king[0] - position.row;
                position.dir_x = king[0] - position.row < 0 ? -1 : 1;
                position.dir_y = king[1] - position.col < 0 ? -1 : 1;
                attackingQueens.add(position);
            }
        }
        return removeBlockedQueens(attackingQueens, false);
    }


    private List<Position> removeBlockedQueens(List<Position> attackingQueens, boolean rowCol)
    {
        Collections.sort(attackingQueens);
        if (!rowCol)
        {
            for (int i = 0; i < attackingQueens.size(); i++)
            {
                for (int j = 0; j < attackingQueens.size(); j++)
                {
                    if (i == j)
                        continue;
                    if (attackingQueens.get(i).diff > 0
                        && attackingQueens.get(i).diff < attackingQueens.get(j).diff
                        && attackingQueens.get(i).dir_x == attackingQueens.get(j).dir_x
                        && attackingQueens.get(i).dir_y == attackingQueens.get(j).dir_y)
                    {
                        attackingQueens.remove(j);
                        i--;
                        break;
                    }
                    else if (attackingQueens.get(i).diff < 0
                        && attackingQueens.get(i).diff > attackingQueens.get(j).diff
                        && attackingQueens.get(i).dir_x == attackingQueens.get(j).dir_x
                        && attackingQueens.get(i).dir_y == attackingQueens.get(j).dir_y)
                    {
                        attackingQueens.remove(j);
                        i--;
                        break;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < attackingQueens.size() - 1; i++)
            {
                if (attackingQueens.get(i).col == attackingQueens.get(i + 1).col || attackingQueens.get(i).row == attackingQueens.get(i + 1).row)
                {
                    if (attackingQueens.get(i).diff > 0 && attackingQueens.get(i + 1).diff > 0)
                    {
                        attackingQueens.remove(i + 1);
                        i--;
                    }
                    else if (attackingQueens.get(i).diff < 0 && attackingQueens.get(i + 1).diff < 0)
                    {
                        attackingQueens.remove(i);
                        i--;
                    }
                }
            }
        }
        return attackingQueens;
    }

    class Position implements Comparable<Position>
    {
        public int row;
        public int col;
        public int diff;
        public int dir_x;
        public int dir_y;


        public Position(int row, int col)
        {
            this.row = row;
            this.col = col;
        }


        @Override
        public int compareTo(Position o)
        {
            if (this.diff > o.diff)
                return 1;
            else if (this.diff < o.diff)
                return -1;
            return 0;
        }
    }
}
