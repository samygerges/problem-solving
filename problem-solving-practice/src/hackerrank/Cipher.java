package hackerrank;

public class Cipher {

	public static void main(String[] args) {
		System.out.println(cipher(4, "1110100110"));
	}

	static String cipher(int k, String s) {
		int n = s.length() - k + 1;
		int[] arr = new int[n];
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (int) s.charAt(i) % 48;

			if (i == 0)
				res[0] = arr[0];
			else if (i < k)
				res[i] = arr[i] ^ arr[i - 1];
			else
				res[i] = arr[i] ^ arr[i - 1] ^ res[i - k];
		}
		String result = "";
		for (int i : res) {
			result += "" + i;
		}
		return result;
	}
}
