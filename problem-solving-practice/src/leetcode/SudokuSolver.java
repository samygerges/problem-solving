package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {
    private final List<Set<Character>> rows = new ArrayList<>();
    private final List<Set<Character>> cols = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // init
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                }
            }
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        char candidate = (char) (k + '0');
                        if (isValidInBox(board, (i / 3) * 3, (j / 3) * 3, candidate)
                                && !rows.get(i).contains(candidate)
                                && !cols.get(j).contains(candidate)) {
                            board[i][j] = candidate;
                            rows.get(i).add(candidate);
                            cols.get(j).add(candidate);
                            if(solve(board) || noDots(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                            rows.get(i).remove(candidate);
                            cols.get(j).remove(candidate);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean noDots(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidInBox(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
