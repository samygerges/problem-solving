import java.awt.Point;
import java.util.ArrayList;

public class TheRoundCityDiv1 {

	public static long find(int r) {
		ArrayList<Point> points = new ArrayList<>();

		int count = 0;
		int negR = -1 * r;
		for (int i = negR; i <= r; i++) {
			for (int j = negR; j <= r; j++) {
				if (i == j && i == 0)
					continue;
				double calc = Math.sqrt((i * i) + (j * j));
				if (calc <= r) {
					boolean check = false;

					for (Point point : points) {
						if (i == 0) {
							if (point.getX() == 0 && i == 0) {
								check = true;
								break;
							} else {
								break;
							}
						} else if ((point.getY()) / (point.getX()) == (j / i)) {
							check = true;
							break;
						}
					}

					if (!check) {
						points.add(new Point(i, j));
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(find(3));
		String s = "babad";
		System.out.println(s.substring(0, s.length()));
	}
}
