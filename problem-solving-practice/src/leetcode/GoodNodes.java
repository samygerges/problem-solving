package leetcode;

public class GoodNodes
{
	public int goodNodes(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		return goodNodes(root, root.val);
	}

	private int goodNodes(TreeNode root, int max)
	{
		if (root == null)
		{
			return 0;
		}

		int count = 0;

		if (root.val >= max)
		{
			count++;
		}
		count += goodNodes(root.left, Math.max(max, root.val));
		count += goodNodes(root.right, Math.max(max, root.val));

		return count;
	}
}
