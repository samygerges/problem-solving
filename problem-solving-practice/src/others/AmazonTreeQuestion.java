package others;

import java.util.ArrayList;
import java.util.List;

public class AmazonTreeQuestion
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode();
		root.val = "A";

		TreeNode node1 = new TreeNode();
		node1.val = "B";

		TreeNode node2 = new TreeNode();
		node2.val = "C";

		TreeNode node3 = new TreeNode();
		node3.val = "D";

		TreeNode node4 = new TreeNode();
		node4.val = "E";

		TreeNode node5 = new TreeNode();
		node5.val = "F";

		TreeNode node6 = new TreeNode();
		node6.val = "G";

		TreeNode node7 = new TreeNode();
		node7.val = "H";

		TreeNode node8 = new TreeNode();
		node8.val = "I";

		root.children = new ArrayList<>();
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);

		node1.children = new ArrayList<>();
		node1.children.add(node4);
		node1.children.add(node5);

		node2.children = new ArrayList<>();
		node2.children.add(node6);

		node3.children = new ArrayList<>();
		node3.children.add(node7);
		node3.children.add(node8);

		System.out.println(new AmazonTreeQuestion().linearize(root));
	}

	static class TreeNode
	{
		String val;
		List<TreeNode> children;
	}

	String linearize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();
		linearize(root, sb);
		int count = 0;
		for (int i = sb.length() - 1; i >= 0; i--)
		{
			if (sb.charAt(i) == '_')
			{
				count++;
			}
			else
			{
				break;
			}
		}
		return sb.substring(0, sb.length() - count);
	}

	void linearize(TreeNode root, StringBuilder sb)
	{
		if (root == null)
		{
			return;
		}
		sb.append(root.val);
		if (root.children != null)
		{
			for (int i = 0; i < root.children.size(); i++)
			{
				linearize(root.children.get(i), sb);
				sb.append("_");
			}
		}
	}
}
