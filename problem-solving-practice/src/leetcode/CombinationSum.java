package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), answer, 0);
        return answer;
    }

	private void backtrack(int[] candidates, int target, int currentSum, List<Integer> currentList, List<List<Integer>> answer, int currentIndex) {
        if(currentSum == target) {
            answer.add(new ArrayList<>(currentList));
            return;
        }
        if(currentSum > target) {
            return;
        }
        
        for(int i = currentIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(candidates, target, currentSum + candidates[i], currentList, answer, i);    
            currentList.remove(currentList.size() - 1);
        }
    }
}
