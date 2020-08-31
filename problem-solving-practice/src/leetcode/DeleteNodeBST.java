package leetcode;

public class DeleteNodeBST {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			root = deleteNode(null, root);
		} else {
			search(root, root.left, key);
			search(root, root.right, key);
		}
		return root;
	}

	private TreeNode deleteNode(TreeNode root, TreeNode node) {
		if (root == null) {
			if (node.left != null) {
				root = node.left;
				insertNode(root, node.right);
			} else if (node.right != null) {
				root = node.right;
				insertNode(root, node.left);
			}
		} else {
			if (root.left != null && root.left.val == node.val) {
				if (node.left != null) {
					root.left = node.left;
					insertNode(root.left, node.right);
				} else if (node.right != null) {
					root.left = node.right;
					insertNode(root.left, node.left);
				} else {
					root.left = null;
				}
			} else {
				if (node.right != null) {
					root.right = node.right;
					insertNode(root.right, node.left);
				} else if (node.left != null) {
					root.right = node.left;
					insertNode(root.right, node.right);
				} else {
					root.right = null;
				}
			}
		}
		return root;
	}

	private void insertNode(TreeNode root, TreeNode node) {
		if (node != null) {
			if (root.val > node.val) {
				// insert on left
				if (root.left == null) {
					root.left = node;
				} else {
					insertNode(root.left, node);
				}
			} else {
				// insert on right
				if (root.right == null) {
					root.right = node;
				} else {
					insertNode(root.right, node);
				}
			}
		}
	}

	private void search(TreeNode parent, TreeNode node, int key) {
		if (node == null) {
			return;
		}
		if (node.val == key) {
			deleteNode(parent, node);
		} else {
			search(node, node.left, key);
			search(node, node.right, key);
		}
	}
}
