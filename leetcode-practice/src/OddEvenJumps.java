import java.util.PriorityQueue;

public class OddEvenJumps {

	public int oddEvenJumps(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		Boolean[][] dp = new Boolean[A.length][2];
		int count = 1;
		for (int i = 0; i < A.length - 1; i++) {
			if (oddEvenJumps(A, i, dp, 1)) {
				count++;
			}
		}
		return count;
	}

	private boolean oddEvenJumps(int[] A, int index, Boolean[][] dp, int jump) {
		if (index == A.length - 1)
			return true;
		if (dp[index][jump % 2] != null)
			return dp[index][jump % 2];

		if (jump % 2 == 0) {
			int ind = getSmallest(A, index, A[index]);
			if (ind == -1) {
				dp[index][jump % 2] = false;
				return false;
			}
			dp[index][jump % 2] = oddEvenJumps(A, ind, dp, jump + 1);
		} else {
			int ind = getLarget(A, index, A[index]);
			if (ind == -1) {
				dp[index][jump % 2] = false;
				return false;
			}
			dp[index][jump % 2] = oddEvenJumps(A, ind, dp, jump + 1);
		}
		return dp[index][jump % 2];
	}

	private int getSmallest(int[] A, int index, int value) {
		int smallest = Integer.MAX_VALUE;
		int ind = -1;
		for (int i = index + 1; i < A.length; i++) {
			if (A[i] <= value && A[i] < smallest) {
				smallest = A[i];
				ind = i;
			}
		}
		for (int i = index + 1; i < A.length; i++) {
			if (A[i] <= value && A[i] > smallest) {
				smallest = A[i];
				ind = i;
			}
		}
		return ind;
	}

	private int getLarget(int[] A, int index, int value) {
		int larget = Integer.MIN_VALUE;
		int ind = -1;

		for (int i = index + 1; i < A.length; i++) {
			if (A[i] >= value && A[i] > larget) {
				larget = A[i];
				ind = i;
			}
		}
		for (int i = index + 1; i < A.length; i++) {
			if (A[i] >= value && A[i] < larget) {
				larget = A[i];
				ind = i;
			}
		}
		return ind;
	}

	public static void main(String[] args) {
		OddEvenJumps a = new OddEvenJumps();
		System.out.println(a.oddEvenJumps(new int[] { 1, 2, 3, 2, 1, 4, 4, 5 }));
	}
}
