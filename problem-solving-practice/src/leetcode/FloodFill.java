package leetcode;

public class FloodFill {

	private static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean[][] visited = new boolean[image.length][image[0].length];
		fillPoints(image, sr, sc, newColor, image[sr][sc], visited);
		return image;
	}

	private void fillPoints(int[][] image, int sr, int sc, int newColor, int color, boolean[][] visited) {
		image[sr][sc] = newColor;
		visited[sr][sc] = true;
		for (int[] dir : directions) {
			if (sr + dir[0] < image.length && sr + dir[0] > -1 && sc + dir[1] < image[sr].length && sc + dir[1] > -1
					&& !visited[sr + dir[0]][sc + dir[1]] && image[sr + dir[0]][sc + dir[1]] == color) {
				fillPoints(image, sr + dir[0], sc + dir[1], newColor, color, visited);
			}
		}
	}
}
