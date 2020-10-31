package leetcode;

public class RecoverBinarySearchTree
{
	boolean swapped = true;
	public void recoverTree(TreeNode root) {
		while(swapped) {
			swapped = false;
			dfs(root, null, null);
		}
	}

	private void dfs(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return;
		}

		if(max != null) {
			if (root.val > max.val) {
				swapped = swapped || true;
				swap(root, max);
			}
		}

		if(min != null) {
			if(root.val < min.val) {
				swapped = swapped || true;
				swap(root, min);
			}
		}

		dfs(root.left, min, root);
		dfs(root.right, root, max);
	}

	private void swap(TreeNode node1, TreeNode node2) {
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}
}
