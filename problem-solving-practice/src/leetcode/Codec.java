package leetcode;

public class Codec { // 5,2,1,3,7,6,8
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		serialize(root.left, sb);
		serialize(root.right, sb);
		return sb.toString();
	}

	private void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(",");
			return;
		}

		sb.append(",").append(root.val);
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String[] nodes = data.split(",");
		TreeNode root = new TreeNode();
		root.val = Integer.parseInt(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			if (!nodes[i].isEmpty()) {
				insertNode(root, Integer.parseInt(nodes[i]));
			}
		}

		return root;
	}

	private void insertNode(TreeNode root, int val) {
		if (val < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				insertNode(root.left, val);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				insertNode(root.right, val);
			}
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;