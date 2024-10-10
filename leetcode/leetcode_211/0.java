class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    public void addWord(String word) {
        if (word.length() == 0) return;
        TrieNode current = root;
        for(char c:word.toCharArray()) {
            if (current.getChar(c) != null)
                current = current.getChar(c);
            else current = current.addChar(c);
        }
        current.setEnd();
    }
    
    public boolean search(String word) {
        if (word.length() == 0) return true;
        TrieNode current = root;
        return root.search(word.toCharArray(), 0);
    }

    private int getIndex(char c) {
        return (int)(c - 'a');
    }
}

class TrieNode {
    char c;
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(char c) {
        this.c = c;
        isEnd = false;
        children = new TrieNode[26];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public TrieNode addChar(char c) {
        TrieNode node = new TrieNode(c);
        children[getIndex(c)] = node;
        return node;
    }

    public TrieNode getChar(char c) {
        return children[getIndex(c)];
    }
    public boolean search(char[] text, int index) {
        //System.out.println(this.c);
        if (index == text.length) {
            return isEnd;
        }
        if (text[index] == '.') {
            if (index == text.length) {
                return isEnd;
            }
            for(TrieNode child:children) {
                if (child != null) {
                    if (child.search(text, index + 1)) 
                        return true;
                }
            }
            return false;
        }

        

        if (children[getIndex(text[index])] == null) 
            return false;
  
        return children[getIndex(text[index])].search(text, index + 1);
    }

    private int getIndex(char c) {
        return (int)(c - 'a');
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */