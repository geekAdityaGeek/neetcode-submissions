class PrefixTree {
    TrieNode head;

    public PrefixTree() {
        head = new TrieNode();
    }

    private void insertIntoTrie(TrieNode node, String word, int pos) {
        if (pos >= word.length()) {
            node.isEnd = true;
            return;
        }
        char ch = word.charAt(pos);
        if (node.child[ch - 'a'] == null) {
            node.child[ch - 'a'] = new TrieNode();
        }
        insertIntoTrie(node.child[ch - 'a'], word, pos + 1);
    }

    public void insert(String word) {
        insertIntoTrie(head, word, 0);
    }

    private boolean searchInTrie(TrieNode node, String word, int pos, boolean isPrefix) {
        if (pos == word.length()) {
            return isPrefix ? true : node.isEnd;
        }
        char ch = word.charAt(pos);
        if (node.child[ch - 'a'] == null) {
            return false;
        }
        return searchInTrie(node.child[ch - 'a'], word, pos + 1, isPrefix);
    }

    public boolean search(String word) {
        return searchInTrie(head, word, 0, false);
    }

    public boolean startsWith(String prefix) {
        return searchInTrie(head, prefix, 0, true);
    }
}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
