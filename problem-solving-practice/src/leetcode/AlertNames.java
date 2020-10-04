package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertNames {
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<int[]>> map = new HashMap<>();
		for (String s : keyName) {
			map.putIfAbsent(s, new ArrayList<>());
		}

		for (int i = 0; i < keyName.length; i++) {
			String[] time = keyTime[i].split(":");
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(time[0]);
			arr[1] = Integer.parseInt(time[1]);
			map.get(keyName[i]).add(arr);
		}
		List<String> answer = new ArrayList<>();
		for (String s : map.keySet()) {
			List<int[]> times = map.get(s);
			Collections.sort(times, (a, b) -> {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				return a[0] - b[0];
			});
			for (int i = 0; i < times.size() - 2; i++) {
				int[] time1 = times.get(i);
				int[] time2 = times.get(i + 1);
				int[] time3 = times.get(i + 2);
				int min = time1[0] == time2[0] ? time2[1] - time1[1] : 60 - time1[1] + time2[1];
				min += time2[0] == time3[0] ? time3[1] - time2[1] : 60 - time2[1] + time3[1];

				if (time3[0] - time1[0] <= 1 && min <= 60) {
					answer.add(s);
					break;
				}
			}
		}

		Collections.sort(answer);
		return answer;
	}
}
