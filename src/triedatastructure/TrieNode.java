package triedatastructure;

public class TrieNode {

    static final int ALPHABET_SIZE = 26;
    TrieNode children[];
    boolean isEndOfWord;

    TrieNode(){
        isEndOfWord = false;
        for (int i = 0; i <ALPHABET_SIZE ; i++) {
            children[i] = null;
        }
    }


    void insert(TrieNode node , String key){
        TrieNode curNode = node;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curNode.children[ch-'a']==null){
                TrieNode newNode = new TrieNode();
                curNode.children[ch-'a'] = newNode;
            }
            curNode = curNode.children[ch-'a'];
        }
        curNode.isEndOfWord =true;
    }


    boolean search(TrieNode node , String key){
        TrieNode curNode = node;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curNode.children[ch-'a']==null) return false;
            curNode = curNode.children[ch-'a'];
        }
        return curNode.isEndOfWord;
    }
}


