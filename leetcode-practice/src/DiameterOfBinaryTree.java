import javafx.util.Pair;

public class DiameterOfBinaryTree
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        return dfs(root).getKey();
    }


    private Pair<Integer, Integer> dfs(TreeNode root)
    {
        if (root == null)
        {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);

        int diameter = Math.max(left.getKey(), Math.max(right.getKey(), left.getValue() + right.getValue()));
        return new Pair<>(diameter, Math.max(left.getValue(), right.getValue()) + 1);
    }
}
