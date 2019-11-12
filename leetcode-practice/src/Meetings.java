import java.math.BigInteger;
import java.util.Arrays;

public class Meetings {

	public static int getMaxNumberOfMeetingsToAttendSimple(Meeting[] arr, int yourTime) {
		int result = 0;

		if (arr == null || arr.length == 0)
			return result;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].minutes <= yourTime) {
				result++;
				yourTime -= arr[i].minutes;
			} else
				break;
		}

		return result;
	}

	public static int getMaxNumberOfMeetingsToAttendAdvancedDB(Meeting[] arr, int yourTime) {
		int[][] memo = new int[arr.length + 1][yourTime + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= yourTime; j++) {
				if (arr[i].minutes <= yourTime) {
					memo[i][j] = Math.max(memo[i - 1][j], arr[i].people + memo[i - 1][yourTime - arr[i].minutes]);
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}

		return memo[arr.length - 1][yourTime];
	}

	public static int getMaxNumberOfMeetingsToAttendAdvanced(Meeting[] arr, int yourTime) {
		boolean[] visited = new boolean[arr.length];
		int max = getMaxNumberOfMeetingsToAttendAdvanced(arr, visited, yourTime);

		return max;
	}

	private static int getMaxNumberOfMeetingsToAttendAdvanced(Meeting[] arr, boolean[] visited, int yourTime) {
		if (yourTime <= 0)
			return 0;

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i] && yourTime >= arr[i].minutes) {
				visited[i] = true;
				max = Math.max(max, arr[i].people
						+ getMaxNumberOfMeetingsToAttendAdvanced(arr, visited, yourTime - arr[i].minutes));
				visited[i] = false;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Meeting meeting1 = new Meeting("X1", 45, 3);
		Meeting meeting2 = new Meeting("X2", 20, 4);
		Meeting meeting3 = new Meeting("X3", 40, 5);
		Meeting meeting4 = new Meeting("X4", 40, 6);
		Meeting meeting5 = new Meeting("X5", 120, 10);

		Meeting[] arr = { meeting1, meeting2, meeting3, meeting4, meeting5 };

		// System.out.println(Meetings.getMaxNumberOfMeetingsToAttendSimple(arr, 95));
		//System.out.println(Meetings.getMaxNumberOfMeetingsToAttendAdvanced(arr, 100));
		//System.out.println(Meetings.getMaxNumberOfMeetingsToAttendAdvancedDB(arr, 100));
		
		BigInteger sum = new BigInteger("4");
		sum = sum.add(new BigInteger("6"));
		
		System.out.println(sum.toString());
	}

}

class Meeting implements Comparable<Meeting> {
	public String name;
	public int minutes;
	public int people;

	public Meeting(String name, int minutes, int people) {
		this.name = name;
		this.minutes = minutes;
		this.people = people;
	}

	public int compareTo(Meeting other) {
		return minutes < other.minutes ? -1 : 1;
	}
}
