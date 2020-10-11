package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch2
{
	private TrieNode root = new TrieNode();
	private int[][] pos = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	class TrieNode
	{
		Map<Character, TrieNode> children;
		boolean isWord;
		String content;

		TrieNode()
		{
			children = new HashMap<>();
		}
	}

	public List<String> findWords(char[][] board, String[] words)
	{
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (String word : words)
		{
			insert(word);
		}
		Set<String> res = new HashSet<>();
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (startsWith("" + board[i][j]))
				{
					visited[i][j] = true;
					backtrack(board, "" + board[i][j], i, j, res, visited);
					visited[i][j] = false;
				}
			}
		}
		List<String> answer = new ArrayList<>(res);
		Collections.sort(answer);
		return answer;
	}

	private void backtrack(char[][] board, String prefix, int r, int c, Set<String> res, boolean[][] visited)
	{
		if (search(prefix))
		{
			res.add(prefix);
		}

		for (int[] p : pos)
		{
			if (r + p[0] > -1 && r + p[0] < board.length && c + p[1] > -1 && c + p[1] < board[r].length && !visited[r + p[0]][c + p[1]])
			{
				if (startsWith(prefix + board[r + p[0]][c + p[1]]))
				{
					visited[r + p[0]][c + p[1]] = true;
					backtrack(board, prefix + board[r + p[0]][c + p[1]], r + p[0], c + p[1], res, visited);
					visited[r + p[0]][c + p[1]] = false;
				}
			}
		}

	}

	public void insert(String word)
	{
		TrieNode current = root;
		for (char c : word.toCharArray())
		{
			current = current.children.computeIfAbsent(c, node -> new TrieNode());
		}
		current.isWord = true;
		current.content = word;
	}

	public boolean search(String word)
	{
		TrieNode current = root;
		for (char c : word.toCharArray())
		{
			current = current.children.get(c);
			if (current == null)
			{
				return false;
			}
		}
		return current.isWord;
	}

	public boolean startsWith(String prefix)
	{
		TrieNode current = root;
		for (char c : prefix.toCharArray())
		{
			current = current.children.get(c);
			if (current == null)
			{
				return false;
			}
		}
		return true;
	}
}
