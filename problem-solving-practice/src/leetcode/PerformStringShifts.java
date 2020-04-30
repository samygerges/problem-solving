package leetcode;

public class PerformStringShifts {
	public static void main(String[] args) {
		PerformStringShifts s = new PerformStringShifts();
		// System.out.println(s.stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));
		System.out.println(s.stringShift("wpdhhcj",
				new int[][] { { 0, 7 }, { 1, 7 }, { 1, 0 }, { 1, 3 }, { 0, 3 }, { 0, 6 }, { 1, 2 } }));
		// System.out.println(s.stringShift("yisxjwry",
		// new int[][] { { 1, 8 }, { 1, 4 }, { 1, 3 }, { 1, 6 }, { 0, 6 }, { 1, 4 }, {
		// 0, 2 }, { 0, 1 } }));
	}

	public String stringShift(String s, int[][] shift) {
		int sh = -1;
		int amount = 0;

		for (int i = 0; i < shift.length; i++) {
			if (sh == -1) {
				sh = shift[i][0];
				amount = shift[i][1];
			} else if (sh == shift[i][0]) {
				amount += shift[i][1];
			} else {
				if (amount - shift[i][1] > 0) {
					amount -= shift[i][1];
				} else {
					sh = shift[i][0];
					amount = shift[i][1] - amount;
				}
			}
		}

		if (sh == 0 && s.length() > 1) {
			for (int i = 0; i < amount; i++) {
				char c = s.charAt(0);
				s = s.substring(1);
				s = s + c;
			}
		} else {
			for (int i = 0; i < amount; i++) {
				char c = s.charAt(s.length() - 1);
				s = s.substring(0, s.length() - 1);
				s = c + s;
			}
		}
		return s;
	}
}
