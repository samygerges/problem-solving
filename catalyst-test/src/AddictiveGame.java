
public class AddictiveGame {

	public static void main(String[] args) {
		AddictiveGame a = new AddictiveGame();
		System.out.println(a.gameIndex("100 100 20 1 123 5464 5567 1055 8754 4544 5 9999 10000 5870 6988 1234 4544 5 7532 2369 7777 1111 8794"));
	}

	public String gameIndex(String str) {
		String res = "";
		String[] arr = str.split(" ");
		// int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);

		for (int i = 3; i < arr.length; i++) {
			int index = Integer.parseInt(arr[i]);
			
			int rowInd = (int) Math.ceil((double) index / (double) col);
			int colInd = index % col == 0 ? 4 : index % col;
			res += rowInd + " " + colInd + " ";
		}
		return res;
	}

}
