package hackerrank;

public class CircularArrayRotation {

	public static void main(String[] args) {
		int[] arr = circularArrayRotation(new int[] { 3, 4, 5 }, 3, new int[] { 0, 1, 2 });
		for (int i : arr)
			System.out.println(i);
	}

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] res = new int[queries.length];
		int rotation = k % a.length;
		int[] arr = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[(i + rotation) % a.length] = a[i];
		}
		for (int i = 0; i < queries.length; i++) {
			res[i] = arr[queries[i]];
		}
		return res;
	}
}
