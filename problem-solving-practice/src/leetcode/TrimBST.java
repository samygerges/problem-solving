package leetcode;

public class TrimBST
{

	public TreeNode trimBST(TreeNode root, int low, int high)
	{
		if (root == null)
		{
			return root;
		}
		if (root.val > high)
		{
			return trimBST(root.left, low, high);
		}
		if (root.val < low)
		{
			return trimBST(root.right, low, high);
		}

		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}

	private TreeNode trimBST(TreeNode parent, TreeNode root, int low, int high, boolean left)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val < low || root.val > high)
		{
			if (parent == null)
			{
				if (root.left != null)
				{
					addNodeToTree(root.left, root.right);
					root = root.left;
					trimBST(null, root, low, high, false);
				}
				else
				{
					root = root.right;
					trimBST(null, root, low, high, false);
				}
			}
			else
			{
				if (left)
				{
					parent.left = null;
				}
				else
				{
					parent.right = null;
				}
				addNodeToTree(parent, root.left);
				addNodeToTree(parent, root.right);
			}
		}
		trimBST(root, root.left, low, high, true);
		trimBST(root, root.right, low, high, false);
		return root;
	}

	private void addNodeToTree(TreeNode root, TreeNode node)
	{
		if (node == null || root == null)
		{
			return;
		}
		if (root.left == null && node.val < root.val)
		{
			root.left = node;
		}
		if (root.right == null && node.val > root.val)
		{
			root.right = node;
		}
		if (root.left != null && root.left.val > node.val)
		{
			addNodeToTree(root.left, node);
		}
		else
		{
			addNodeToTree(root.right, node);
		}
	}
}
