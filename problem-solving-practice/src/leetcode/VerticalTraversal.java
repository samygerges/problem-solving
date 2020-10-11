package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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
}
