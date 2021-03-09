package leetcode;

public class AddOneRow
{
	public TreeNode addOneRow(TreeNode root, int v, int d)
	{
		if (d == 1)
		{
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		addOneRow(root, v, d, 1);
		return root;
	}

	private void addOneRow(TreeNode root, int v, int d, int level)
	{
		if (level + 1 == d)
		{
			TreeNode left = new TreeNode(v);
			left.left = root.left;
			root.left = left;
			TreeNode right = new TreeNode(v);
			right.right = root.right;
			root.right = right;
		}
		else
		{
			addOneRow(root.left, v, d, level + 1);
			addOneRow(root.right, v, d, level + 1);
		}
	}
}
