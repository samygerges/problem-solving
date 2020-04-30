package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		Map<List<Integer>, Integer> map = new HashMap<>();
		return shoppingOffers(price, special, needs, map);
	}

	private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
			Map<List<Integer>, Integer> map) {
		if (map.containsKey(needs))
			return map.get(needs);

		int res = getPriceWithoutOffer(price, needs);
		int j = 0;
		for (int i = 0; i < special.size(); i++) {
			List<Integer> clone = new ArrayList<>(needs);
			for (j = 0; j < clone.size(); j++) {
				int diff = clone.get(j) - special.get(i).get(j);
				if (diff < 0)
					break;
				clone.set(j, diff);
			}
			if (j == needs.size()) {
				res = Math.min(res,
						special.get(i).get(special.get(i).size() - 1) + shoppingOffers(price, special, clone, map));
			}
		}

		map.put(needs, res);
		return res;
	}

	private int getPriceWithoutOffer(List<Integer> price, List<Integer> needs) {
		int sum = 0;
		for (int i = 0; i < price.size(); i++) {
			sum += price.get(i) * needs.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		ShoppingOffers a = new ShoppingOffers();
		List<Integer> price = new ArrayList<>();
		price.add(2);
		price.add(5);

		List<Integer> needs = new ArrayList<>();
		needs.add(3);
		needs.add(2);

		List<List<Integer>> special = new ArrayList<>();
		List<Integer> offer1 = new ArrayList<>();
		offer1.add(3);
		offer1.add(0);
		offer1.add(5);
		special.add(offer1);

		List<Integer> offer2 = new ArrayList<>();
		offer2.add(1);
		offer2.add(2);
		offer2.add(10);
		special.add(offer2);

		// [2,5], [[3,0,5],[1,2,10]], [3,2]
		// answer should be 14
		System.out.println(a.shoppingOffers(price, special, needs));

	}

}
