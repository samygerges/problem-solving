import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BritishCoins {
	
	public int[] coins(int pence) {
		int[] answer = new int[3];
		answer[0] = pence / 240;
		pence -= (answer[0] * 240);
		answer[1] = pence / 12;
		pence -= (answer[1] * 12);
		answer[2] = pence;
		return answer;
	}
}
