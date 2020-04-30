package hackerrank;
import java.util.Stack;

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			int j = i + 1 < gas.length ? i + 1 : 0;
			int preI = i - 1 >= 0 ? i - 1 : gas.length - 1;
			int tank = gas[i];
			boolean check = true;
			while (j != i) {
				int next = j + 1 < gas.length ? j + 1 : 0;
				int pre = j - 1 >= 0 ? j - 1 : gas.length - 1;

				if (tank - cost[pre] < 0) {
					check = false;
					break;
				}
				tank += gas[j] - cost[pre];

				if (tank < 0) {
					check = false;
					break;
				}
				j = next;
			}

			if (tank - cost[preI] >= 0 && check)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(Character.isDigit('0'));
		Stack<Character> stack;
		String[] words = {"{mee","hum_","dkoe","12f"};
		for(String s:words)
		{
			if(s.matches("[abb]"))
		    {
		        System.out.println(s);
		    }
		}
	}

}
