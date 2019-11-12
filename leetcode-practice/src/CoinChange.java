
public class CoinChange {

	public static int change(int amount, int[] coins) {
		return change(amount, coins, 0, 0);
	}

	private static int change(int amount, int[] coins, int current, int start) {
		if (current == amount)
			return 1;
		else if (current > amount)
			return 0;

		int count = 0;
		for (int i = start; i < coins.length; i++) {
			count += change(amount, coins, current + coins[i], start + i);
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(change(500, new int[] { 1, 2, 5 }));
	}
}
