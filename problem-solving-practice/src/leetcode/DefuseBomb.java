package leetcode;

public class DefuseBomb {
	public static void main(String[] args) {
		System.out.println(new DefuseBomb().decrypt(new int[] { 2, 4, 9, 3 }, -2));
	}

	public int[] decrypt(int[] code, int k) {
		int[] ans = new int[code.length];
		if (k == 0) {
			for (int i = 0; i < code.length; i++) {
				ans[i] = 0;
			}
		} else if (k > 0) {
			for (int i = 0; i < code.length; i++) {
				int count = 0;
				int j = i + 1;
				int sum = 0;
				while (count < k) {
					sum += code[j % code.length];
					j++;
					count++;
				}
				ans[i] = sum;
			}
		} else {
			for (int i = 0; i < code.length; i++) {
				int count = 0;
				int j = i - 1;
				int sum = 0;
				while (count < Math.abs(k)) {
					if (j < 0) {
						j = code.length - 1;
					}
					sum += code[j];
					j--;
					count++;
				}
				ans[i] = sum;
			}
		}
		return ans;
	}
}
