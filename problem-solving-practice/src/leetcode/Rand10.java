package leetcode;

public class Rand10
{
	public int rand10() {
		int row = rand7();
		int col = rand7();
		int index = ((row - 1) * 7) + col;
		while(index > 40) {
			row = rand7();
			col = rand7();
			index = ((row - 1) * 7) + col;
		}
		return index % 10 + 1;
	}

	public int rand7(){
		return (int) Math.random() * 7;
	}
}
