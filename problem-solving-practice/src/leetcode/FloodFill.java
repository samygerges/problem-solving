package leetcode;

public class FloodFill {

	private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]) return image;
        fillPoints(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void fillPoints(int[][] image, int sr, int sc, int newColor, int color)
    {   
        image[sr][sc] = newColor;
        for(int[] dir : directions) {
            if(sr + dir[0] < image.length && sr + dir[0] >-1 && sc + dir[1] < image[sr].length && 
               sc + dir[1] > -1 && image[sr + dir[0]][sc + dir[1]] == color) {
                fillPoints(image, sr + dir[0], sc + dir[1], newColor, color);    
            }
        }    
    }
}
