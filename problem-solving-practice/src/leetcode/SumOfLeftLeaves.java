package leetcode;

public class SumOfLeftLeaves
{
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int sum = sumOfLeftLeaves(root.left, 0, true);
		sum += sumOfLeftLeaves(root.right, 0, false);
		return sum;
	}

	private int sumOfLeftLeaves(TreeNode root, int sum, boolean left) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null && left) {
			return root.val;
		}
		if(root.left != null) {
			sum += sumOfLeftLeaves(root.left, 0, true);
		}
		if(root.right != null) {
			sum += sumOfLeftLeaves(root.right, 0, false);
		}
		return sum;
	}
}
