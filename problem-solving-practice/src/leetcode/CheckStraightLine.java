package leetcode;

public class CheckStraightLine {
	public boolean checkStraightLine(int[][] coordinates) {
		double globalSlope = -1;
		for (int i = 0; i < coordinates.length - 1; i++) {
			int slope_x = coordinates[i + 1][0] - coordinates[i][0];
			int slope_y = coordinates[i + 1][1] - coordinates[i][1];
			double slope = 0;
			if (slope_x != 0) {
				slope = (double) slope_y / (double) slope_x;
			} else {
				slope = slope_y;
			}
			if (globalSlope == -1) {
				globalSlope = slope;
			} else {
				if (globalSlope != slope) {
					return false;
				}
			}

		}
		return true;
	}
}
