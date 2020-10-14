package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
	public static void main(String[] args)
	{
		System.out.println(new SpiralMatrix().spiralOrder(new int[][]{ {1,2,3},{4,5,6},{7,8,9}}));
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> answer = new ArrayList<>();

		if(matrix== null || matrix.length==0) {
			return answer;
		}
		int n = matrix.length;
		int m = matrix[0].length;

		int count = 0;
		int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		boolean[][] visited = new boolean[n][m];
		int i = 0;
		int j = 0;
		int currentDir = 0;
		while(count < n*m) {
			if(!visited[i][j])
			{
				answer.add(matrix[i][j]);
				count++;
				visited[i][j] = true;
			}
			if(i + dir[currentDir][0] < n && i + dir[currentDir][0] > -1
				&& j + dir[currentDir][1] < m && j + dir[currentDir][1] > -1
				&& !visited[i + dir[currentDir][0]][j + dir[currentDir][1]]) {
				i += dir[currentDir][0];
				j += dir[currentDir][1];
			} else {
				currentDir = (currentDir + 1) % 4;
			}
		}

		return answer;
	}
}
