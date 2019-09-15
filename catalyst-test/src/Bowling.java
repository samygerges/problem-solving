
public class Bowling {
	public static void main(String[] args) {
		Bowling test = new Bowling();
		System.out.println(test.bowlingGame("4:1,5,10,10,1,7"));
		System.out.println(test.bowlingGame("4:1,4,10,10,3,6"));
	}

	public String bowlingGame(String str) {
		String res = "";

		if (str == null || str.equals(""))
			return res;

		String[] arr = str.split(":");
		String[] throwingStr = arr[1].split(",");
		int[] throwing = new int[throwingStr.length];

		int[] score = new int[Integer.parseInt(arr[0])];
		for (int i = 0; i < throwing.length; i++) {
			throwing[i] = Integer.parseInt(throwingStr[i]);
		}

		int scoreCounter = 0;
		for (int i = 0; i < throwing.length; i++) {
			if (scoreCounter < score.length && score[scoreCounter] == 0) {
				score[scoreCounter] = throwing[i];
				if (throwing[i] != 10) {
					score[scoreCounter] += throwing[i + 1];
				}
				if (throwing[i] == 10 && i + 1 < throwing.length) {
					score[scoreCounter] += throwing[i + 1];
					if (i + 2 < throwing.length)
						score[scoreCounter] += throwing[i + 2];
				} else if (score[scoreCounter] == 10 && i + 2 < throwing.length) {
					score[scoreCounter] += throwing[i + 2];
					i += 1;
				} else
					i += 1;
			}
			scoreCounter++;
		}
		for (int i = 1; i < score.length; i++)
			score[i] += score[i - 1];
		for (int i = 0; i < score.length; i++)
			res += score[i] + ",";
		res = res.substring(0, res.length() - 1);
		return res;
	}
}
