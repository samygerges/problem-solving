package leetcode;

import javafx.util.Pair;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        List<Pair<String, HashSet<String>>> prepare = new ArrayList<>();
        Set<Integer> removed = new HashSet<>();
        for (List<String> account : accounts) {
            HashSet<String> set = new HashSet<>();
            Set<Integer> index = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                set.add(account.get(i));
                if (emailToIndex.containsKey(account.get(i)) && emailToIndex.get(account.get(i)) != prepare.size()) {
                    index.add(emailToIndex.get(account.get(i)));
                } else {
                    emailToIndex.put(account.get(i), prepare.size());
                }
            }
            prepare.add(new Pair<>(account.get(0), set));
            if (!index.isEmpty()) {
                for (int i : index) {
                    merge(prepare, emailToIndex, removed, i, prepare.size() - 1);
                }
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < prepare.size(); i++) {
            Pair<String, HashSet<String>> pair = prepare.get(i);
            if (!removed.contains(i)) {
                List<String> account = new ArrayList<>();
                account.add(pair.getKey());
                List<String> emails = new ArrayList<>(pair.getValue());
                Collections.sort(emails);
                account.addAll(emails);
                answer.add(account);
            }
        }
        return answer;
    }

    private void merge(List<Pair<String, HashSet<String>>> answer, Map<String, Integer> emailToIndex, Set<Integer> removed, int i, int j) {
        answer.get(j).getValue().addAll(answer.get(i).getValue());
        for (String email : answer.get(i).getValue()) {
            emailToIndex.put(email, j);
        }
        removed.add(i);
    }
}
