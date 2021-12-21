package leetcode;

import java.util.*;

public class VerticalTraversal
{
	public List<List<Integer>> verticalTraversal(TreeNode root)
	{
		TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
		verticalTraversal(root, map, 0, 0);
		List<List<Integer>> res = new ArrayList<>();
		for (TreeMap<Integer, List<Integer>> levelMap : map.values())
		{
			List<Integer> list = new ArrayList<>();
			for (List<Integer> temp : levelMap.values())
			{
				Collections.sort(temp);
				list.addAll(temp);
			}
			res.add(list);
		}
		return res;
	}

	private void verticalTraversal(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int level, int line)
	{
		map.putIfAbsent(line, new TreeMap<>());
		map.get(line).putIfAbsent(level, new ArrayList<>());
		map.get(line).get(level).add(root.val);
		if (root.left != null)
		{
			verticalTraversal(root.left, map, level + 1, line - 1);
		}
		if (root.right != null)
		{
			verticalTraversal(root.right, map, level + 1, line + 1);
		}
	}


	public List<List<Integer>> verticalTraversal2(TreeNode root) {
		Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
		traverse(root, map, 0, 0);
		List<List<Integer>> answer = new ArrayList<>();
		for(int col : map.keySet()) {
			List<Integer> list = new ArrayList<>();
			Map<Integer, List<Integer>> rowMap = map.get(col);
			for(int row : rowMap.keySet()) {
				Collections.sort(rowMap.get(row));
				list.addAll(rowMap.get(row));
			}

			answer.add(list);
		}
		return answer;
	}

	private void traverse(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int col, int row) {
		if(root == null) {
			return;
		}
		map.putIfAbsent(col, new TreeMap<>());
		map.get(col).putIfAbsent(row, new ArrayList<>());
		map.get(col).get(row).add(root.val);
		traverse(root.left, map, col - 1, row + 1);
		traverse(root.right, map, col + 1, row + 1);
	}
}
