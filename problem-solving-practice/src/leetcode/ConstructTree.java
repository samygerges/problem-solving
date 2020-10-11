package leetcode;

public class ConstructTree
{
	public static void main(String[] args)
	{
		new ConstructTree().buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
	}

	public TreeNode buildTree(int[] inorder, int[] postorder)
	{
		return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int st_inorder, int end_inorder, int[] postorder, int end_postorder)
	{
		if (st_inorder > end_inorder)
		{
			return null;
		}

		TreeNode root = new TreeNode(postorder[end_postorder]);
		int i = st_inorder;
		while (inorder[i] != postorder[end_postorder])
		{
			i++;
		}
		root.left = buildTree(inorder, st_inorder, i - 1, postorder, end_postorder - (end_inorder - i) - 1);
		root.right = buildTree(inorder, i + 1, end_inorder, postorder, end_postorder - 1);

		return root;
	}
}
