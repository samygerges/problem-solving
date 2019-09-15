import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int tt = in.nextInt();
			int[] arr = new int[tt];
			for (int j = 0; j < tt; j++) {
				arr[j] = in.nextInt();
			}
			String res = getAnswer(n, arr);
			System.out.println("Case #" + (i) + ": " + res);
		}

		in.close();
	}

	private static String getAnswer(int n, int[] arr) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
		List<Integer> allPrimes = sieveOfEratosthenes(1000000);
		allPrimes.remove(0);
		int lastIndex = 0;
		for (int i = 0; i < allPrimes.size(); i++) {
			if (allPrimes.get(i) > n) {
				lastIndex = i - 1;
				break;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < allPrimes.size(); i++)
			map.put(allPrimes.get(i), i);

		int firstIndex = lastIndex - 25;
		int first = 0;
		int second = 0;
		int prime = 0;
		String res = "";
		for (int i = firstIndex; i <= lastIndex; i++) {
			boolean check = false;
			for (int j = firstIndex; j <= lastIndex; j++) {
				if (arr[0] == allPrimes.get(i) * allPrimes.get(j)) {
					first = i;
					second = j;
					prime = allPrimes.get(j);
					check = true;
					break;
				}
			}
			if (check)
				break;
		}

		res += alphabet[first - firstIndex];
		for (int i = 1; i < arr.length; i++) {
			res += alphabet[second - firstIndex];
			second = map.get(arr[i] / prime);
			prime = arr[i] / prime;
		}
		res += alphabet[second - firstIndex];
		return res;
	}

	public static List<Integer> sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int i = p * 2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		List<Integer> primeNumbers = new LinkedList<>();
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}
}
