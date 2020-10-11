package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPathSum
{
	public static void main(String[] args)
	{
		MaxPathSum m = new MaxPathSum();
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.right = right;
		right.left = new TreeNode(15);
		right.right = new TreeNode(7);

		System.out.println(m.maxPathSum(root));
	}

	public int maxPathSum(TreeNode root)
	{
		Map<TreeNode, Integer> dp = new HashMap<>();
		TreeNode all = new TreeNode();
		dp.put(all, root.val);
		maxPathSum(root, dp, all);

		int max = root.val;
		for (int i : dp.values())
		{
			max = Math.max(i, max);
		}
		return max;
	}

	private int maxPathSum(TreeNode root, Map<TreeNode, Integer> dp, TreeNode all)
	{
		if (dp.containsKey(root))
		{
			return dp.get(root);
		}
		if (root.left == null && root.right == null)
		{
			dp.put(root, root.val);
			return root.val;
		}
		if (root.left != null)
		{
			dp.put(root.left, maxPathSum(root.left, dp, all));
		}
		if (root.right != null)
		{
			dp.put(root.right, maxPathSum(root.right, dp, all));
		}

		int sum = root.val;
		int sum1 = root.val;
		int sum2 = root.val;
		int allSum = root.val;
		int added = 0;
		if (root.left != null)
		{
			sum1 = Math.max(sum, sum + dp.get(root.left));
			allSum += dp.get(root.left);
		}
		if (root.right != null)
		{
			sum2 = Math.max(sum, sum + dp.get(root.right));
			allSum += dp.get(root.right);
		}

		allSum = Math.max(dp.get(all), allSum);
		dp.put(all, allSum);
		dp.put(root, Math.max(sum1, sum2));

		return dp.get(root);
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode()
	{
	}

	TreeNode(int val)
	{
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
}