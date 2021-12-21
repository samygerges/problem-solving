package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsRods {
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i++) {
            char c = rings.charAt(i);
            int r = rings.charAt(i + 1);
            map.putIfAbsent(r, new HashSet<>());
            map.get(r).add(c);
            i++;
        }
        int count = 0;
        for (int i : map.keySet()) {
            count += map.get(i).size() == 3 ? 1 : 0;
        }
        return count;
    }
}
