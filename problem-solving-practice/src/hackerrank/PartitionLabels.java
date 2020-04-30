package hackerrank;
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static List<Integer> partitionLabels(String S) {
		List<String> strings = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			boolean inserted = false;
			String str = "";
			for (int j = strings.size() - 1; j >= 0; j--) {
				str = strings.get(j) + str;
				if (strings.get(j).indexOf(S.charAt(i)) != -1) {
					for (int k = strings.size() - 1; k >= j; k--) {
						strings.remove(k);
					}
					strings.add(str + S.charAt(i));
					inserted = true;
					break;
				}
			}
			if (!inserted) {
				strings.add("" + S.charAt(i));
			}
		}

		for (String str : strings)
			nums.add(str.length());
		return nums;
	}

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
}
