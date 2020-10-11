package leetcode;

public class IslandPerimeter
{
	public static void main(String[] args)
	{
		IslandPerimeter i = new IslandPerimeter();
		System.out.println(i.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
		System.out.println(i.islandPerimeter(new int[][]{{1,1},{1,1}}));
	}
	public int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					boolean[][] visited = new boolean[grid.length][grid[i].length];
					return dfs(grid, i, j, visited);
				}
			}
		}
		return 0;
	}

	private int[][] pos = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
		int count = 4;

		visited[r][c] = true;
		for(int[] p : pos) {
			if (p[0] + r >= 0 && p[0] + r < grid.length && p[1] + c >= 0 && p[1] + c < grid[r].length && visited[p[0] + r][p[1] + c]) {
				count -= 2;
			}
		}
		for(int[] p : pos) {
			if(p[0] + r >= 0 && p[0] + r < grid.length && p[1] + c >= 0 && p[1] + c < grid[r].length && !visited[p[0] + r][p[1] + c] && grid[p[0] + r][p[1] + c] == 1) {
				count += dfs(grid, p[0] + r, p[1] + c, visited);
			}
		}
		return count;
	}
}
