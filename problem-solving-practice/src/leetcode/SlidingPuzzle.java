package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int n = board.length;
        int m = board[0].length;
        Set<String> seen = new HashSet<>();
        ArrayDeque<Pair<int[][], Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(board, 0));
        while (!queue.isEmpty()) {
            int[][] state = queue.peek().getKey();
            int moves = queue.poll().getValue();
            String boardState = convertToString(state);
            if (boardState.equals(target)) {
                return moves;
            }
            if (!seen.contains(boardState)) {
                seen.add(boardState);
                int[] zero = zeroPosition(state);
                for (int[] dir : dirs) {
                    int[][] newState = copy(state);
                    int r = dir[0] + zero[0];
                    int c = dir[1] + zero[1];
                    if (r >= 0 && r < n && c >= 0 && c < m) {
                        // swap
                        int tmp = newState[r][c];
                        newState[r][c] = newState[zero[0]][zero[1]];
                        newState[zero[0]][zero[1]] = tmp;
                        if (!seen.contains(convertToString(newState))) {
                            queue.add(new Pair<>(newState, moves + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int[][] copy(int[][] board) {
        int[][] newBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    private int[] zeroPosition(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private String convertToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : board) {
            for (int j : arr) {
                sb.append(j);
            }
        }
        return sb.toString();
    }
}
