package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSuggestionsSystem
{

    public static void main(String[] args)
    {
        SearchSuggestionsSystem s = new SearchSuggestionsSystem();
        System.out.println(s.suggestedProducts(new String[] {"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
    }

    class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean isWord;
        String content;


        public TrieNode()
        {
            children = new HashMap<>();
        }
    }


    private void buildTrie(String[] products, TrieNode root)
    {
        for (String word : products)
        {
            TrieNode current = root;
            for (char c : word.toCharArray())
            {
                current = current.children.computeIfAbsent(c, node -> new TrieNode());
            }
            current.isWord = true;
            current.content = word;
        }
    }


    private List<String> findByPrefix(String prefix, TrieNode root)
    {
        TrieNode current = root;
        for (char c : prefix.toCharArray())
        {
            TrieNode node = current.children.get(c);
            if (node == null)
            {
                return Collections.emptyList();
            }
            current = node;
        }
        // loop over all words in current
        List<String> result = new ArrayList<>();
        findWordsInNode(current, result);
        Collections.sort(result);
        if (result.size() > 3)
        {
            result = result.subList(0, 3);
        }
        return result;
    }


    private void findWordsInNode(TrieNode root, List<String> result)
    {
        if (root == null)
        {
            return;
        }
        if (root.isWord)
        {
            result.add(root.content);
        }
        for (TrieNode node : root.children.values())
        {
            findWordsInNode(node, result);
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        TrieNode root = new TrieNode();
        buildTrie(products, root);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++)
        {
            result.add(findByPrefix(searchWord.substring(0, i + 1), root));
        }
        return result;
    }
}
