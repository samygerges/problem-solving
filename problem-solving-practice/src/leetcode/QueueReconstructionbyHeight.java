package leetcode;

public class QueueReconstructionbyHeight {
	public static void main(String[] args) {
		int[][] arr = new QueueReconstructionbyHeight()
				.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });
		for (int[] i : arr) {
			System.out.print("[" + i[0] + ", " + i[1] + "] ");
		}
	}

	public int[][] reconstructQueue(int[][] people) {
		int h = 0;
		boolean[] visited = new boolean[people.length];
		int[][] queue = new int[people.length][2];
		for (int[] i : queue) {
			i[0] = -1;
		}

		for (int i = 0; i < people.length; i++) {
			int index = getMin(people, h, visited);
			h = people[index][0];
			int before = people[index][1];
			int taller = 0;
			for (int j = 0; j < queue.length; j++) {
				if (h <= queue[j][0] || queue[j][0] == -1) {
					taller++;
				}
				if (taller > before && queue[j][0] == -1) {
					swap(queue, j, people[index]);
					visited[index] = true;
					break;
				}
			}
		}
		return queue;
	}

	private int getMin(int[][] people, int start, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < people.length; i++) {
			if (!visited[i] && people[i][0] >= start && people[i][0] < min) {
				index = i;
				min = people[i][0];
			}
		}
		return index;
	}

	public void swap(int[][] people, int i, int[] person) {
		people[i][0] = person[0];
		people[i][1] = person[1];
	}
}
