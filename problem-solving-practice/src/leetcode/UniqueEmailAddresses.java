package leetcode;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public int numUniqueEmails(String[] emails) {
		if (emails == null || emails.length == 0)
			return 0;
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			String[] arr = email.split("@");
			arr[0] = arr[0].replaceAll("\\.", "");
			int index = arr[0].indexOf("+");
			if (index != -1) {
				arr[0] = arr[0].substring(0, index);
			}
			set.add(arr[0] + "@" + arr[1]);
		}
		return set.size();
	}

	public static void main(String[] args) {
		UniqueEmailAddresses a = new UniqueEmailAddresses();
		System.out.println(
				a.numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.email.leet+alex@code.com" }));
	}
}
