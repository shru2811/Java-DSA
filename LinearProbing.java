import java.util.ArrayList;

public class LinearProbing {
    String[] hashtable;
    int cellCount;
    LinearProbing(int size){
        hashtable = new String[size];
        cellCount = 0;
    }
    public static int modASCII(String word, int m){
        char[] ch = word.toCharArray();
        int sum=0;
        for(char c: ch){
            sum+=c;
        }
        return sum%m;
    }
    // if the hashtable is going to get filled it should increase its length
    //loadfactor tells this when to double its size
    public double getLoadFactor(){
        double res = cellCount * 1.0/hashtable.length;
        return res;
    }
    //if the load factor > 75% then the new word will be added after doubling the hashtable size
    public void rehashKey(String word){
        cellCount = 0;
        ArrayList<String> data = new ArrayList<>();
        for(String i: hashtable){
            if(i!=null){
                data.add(i);
            }
        }
        data.add(word);
        hashtable = new String[hashtable.length*2];
        for(String d: data){
            insert(d);
        }
    }
    //insert algo for linear probing to place new key in closest following empty cell
    public void insert(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75){
            rehashKey(word);
        }else{
            int index = modASCII(word,hashtable.length);
            for(int i=index; i<index+hashtable.length;i++){
                int ind = i%hashtable.length;
                if(hashtable[ind]==null){
                    hashtable[ind] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+ind);
                    break;
                }else{
                    System.out.println(ind+" is already occupied . Trying next empty cell");
                }
            }
        }
        cellCount++;
    }
    public void displayHashTable() {
        if (hashtable == null) {
            System.out.println("\nHashTable does not exists");
            return;
        } else {
            System.out.println("\n----------HashTable----------");
            for (int i=0; i<hashtable.length; i++) {
                System.out.println("Index " + i + ", key:" + hashtable[i]);
            }
        }
    }
    public boolean searchHashTable(String word) {
        int index = modASCII(word, hashtable.length);
        for (int i = index; i < index+hashtable.length; i++) {
            int newIndex = i % hashtable.length;
            if (hashtable[newIndex] != null && hashtable[newIndex].equals(word)) {
                System.out.println(word +" found at location: "+ newIndex);
                return true;
            }
        }
        System.out.println(word +" not found in hashTable");
        return false;
    }

    public void deleteKeyHashTable(String word) {
        int index = modASCII(word, hashtable.length);
        for (int i = index; i<index+hashtable.length; i++) {
            int newIndex = i % hashtable.length;
            if (hashtable[newIndex] != null && hashtable[newIndex].equals(word)) {
                hashtable[newIndex] = null;
                System.out.println(word +" has been deleted from HashTable");
                return;
            }
        }
        System.out.println(word +" not found in HashTable");
    }
    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing(13);
        lp.insert("The");
        lp.insert("quick");
        lp.insert("brown");
        lp.insert("fox");
        lp.insert("over");
        lp.displayHashTable();

    }
}
