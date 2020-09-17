package leetcode;

public class RobotBoundedCircle {

	public static void main(String[] args) {
		System.out.println(new RobotBoundedCircle().isRobotBounded("LLGRL"));
	}

	public boolean isRobotBounded(String instructions) {
		int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int x = 0;
		int y = 0;
		int index = 0;
		for (int i = 0; i < instructions.length(); i++) {
			if (instructions.charAt(i) == 'L') {
				if (index == 0) {
					index = 3;
				} else if (index == 1) {
					index = 2;
				} else if (index == 2) {
					index = 0;
				} else {
					index = 1;
				}
			} else if (instructions.charAt(i) == 'R') {
				if (index == 0) {
					index = 2;
				} else if (index == 1) {
					index = 3;
				} else if (index == 2) {
					index = 1;
				} else {
					index = 0;
				}
			} else {
				x += direction[index][0];
				y += direction[index][1];
			}
		}
		if (x == 0 && y == 0)
			return true;

		return index == 0 ? false : true;
	}
}
