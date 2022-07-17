package binarytree;

public class Trie_208 {

    class TrieNode {
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie_208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }
            node = node.next[ch -'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            node = node.next[ch - 'a'];
            if (node == null){
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            node = node.next[ch - 'a'];
            if (node == null){
                return false;
            }
        }
        return true;
    }
}
