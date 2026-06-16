class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        add(word, 0, root);
    }

    private void add(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            node.isEnd = true;
            return;
        }
        int idx = word.charAt(pos) - 'a';
        if(node.child[idx] == null) {
            node.child[idx] = new TrieNode();
        }
        add(word, pos + 1, node.child[idx]);
    }

    private boolean match(String word, int pos, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (pos == word.length()) {
            return node.isEnd;
        }

        boolean ans = false;
        char ch = word.charAt(pos);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                ans = ans || match(word, pos + 1, node.child[i]);
            }
        } else {
            ans = ans || match(word, pos + 1, node.child[ch - 'a']);
        }

        return ans;
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }
}

class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}
