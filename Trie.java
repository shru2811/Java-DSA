public class Trie {
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    static Node root = new Node();
    public void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int indx = word.charAt(i) - 'a';
            if(curr.children[indx]==null){  //--if the node doesnt have the character then create a node and add one
                curr.children[indx] = new Node();
            }
            if(i == word.length()-1){
                curr.children[indx].eow = true;
            }
            curr = curr.children[indx];
        }
        System.out.println("The word: "+ word + " inserted");
    }

    public boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null)
                return false;               //it will be false in two cases=> if the node value doesnt matches the key
            if(i == word.length()-1 && curr.children[idx].eow == false )
                return false;               //or the end of word is false
            curr = curr.children[idx];
        }
        return true;
    }
    public boolean wordBreak(String key){
        if(key.length()==0)
            return true;
        for(int i=1;i<=key.length();i++){
            String first = key.substring(0,i);
            String second = key.substring(i);
            if(search(first) && wordBreak(second)){
                return true;
            }
        }
        return false;
    }
}
