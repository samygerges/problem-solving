package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsBT
{
	public List<Double> averageOfLevels(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		traverseTree(root, 0, list);
		List<Double> res = new ArrayList<>();
		for(List<Integer> a : list) {
			double sum = 0;
			for(int i : a) {
				sum += i;
			}
			res.add((double) sum / (double) a.size());
		}
		return res;
	}

	private void traverseTree(TreeNode root, int level, List<List<Integer>> list){
		if(root == null) {
			return;
		}
		if(list.size() <= level) {
			list.add(new ArrayList<>());
		}
		list.get(level).add(root.val);
		traverseTree(root.left, level + 1, list);
		traverseTree(root.right, level + 1, list);
	}
}
