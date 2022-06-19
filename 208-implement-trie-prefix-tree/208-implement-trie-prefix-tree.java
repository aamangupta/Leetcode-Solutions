class Node{
    Node link[] = new Node[26];
    boolean flag = false;
    Node(){}
    
    boolean containsKey(char ch){
        if(link[ch - 'a'] != null) return true;
        return false;
    }
    void put(char ch, Node node){
        link[ch - 'a'] = node;
    }
    Node get(char ch){
        return link[ch - 'a'];    
    } 
    
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();    
    }
    
    public void insert(String word) {
        Node node = root;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch) == false){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch) == false){
                return false;
            }
            node = node.get(ch);
        }
        if(node.flag == false) return false;
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        int n = prefix.length();
        for(int i = 0; i < n; i++){
            char ch = prefix.charAt(i);
            if(node.containsKey(ch) == false){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */