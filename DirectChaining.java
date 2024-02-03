import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String> hashtable [];
    int maxDirectChaining = 5;
    DirectChaining(int size){
        hashtable = new LinkedList[size];
    }
    public static int modASCII(String word, int m){
        char[] ch = word.toCharArray();
        int sum=0;
        for(char c: ch){
            sum+=c;
        }
        return sum%m;
    }
    public void insertHashTable(String word){
        int ind = modASCII(word,hashtable.length);
        if(hashtable[ind] == null){
            hashtable[ind] = new LinkedList<>();
            hashtable[ind].add(word);
        }
        else{
            hashtable[ind].add(word);
        }
    }
    public void displayHash(){
        if(hashtable == null){
            System.out.println("------------------Table doesn't exist------------------");
        }
        else{
            System.out.println("------------------Hash table------------------");
            for(int i=0;i<hashtable.length;i++){
                System.out.println("Index: " + i +" key:" + hashtable[i]);
            }
        }
    }

    public boolean search(String word){
        int ind = modASCII(word,hashtable.length);
        if(hashtable[ind]!=null && hashtable[ind].contains(word)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DirectChaining dc = new DirectChaining(16);
        dc.insertHashTable("ABCD");
        dc.insertHashTable("EFGH");
        dc.insertHashTable("IJKLM");
        dc.insertHashTable("shruti");
        dc.displayHash();
        System.out.println(dc.search("abcd"));
        System.out.println(dc.search("EFGH"));
    }
} /*
import java.util.ArrayList;

public class LinearProbing{
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum=0,i=0; i<word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public double getLoadFactor() {
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }

    // Rehash
    public void rehashKeys(String word) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertInHashTable(s);
        }

    }

    // Insert in HashTable
    public void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            for (int i = index; i<index+hashTable.length; i++) {
                int newIndex = i % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+newIndex);
                    break;
                } else {
                    System.out.println(newIndex+" is already occupied . Trying next empty cell");
                }
            }
        }
        usedCellNumber++;

    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exists");
            return;
        } else {
            System.out.println("\n----------HashTable----------");
            for (int i=0; i<hashTable.length; i++) {
                System.out.println("Index " + i + ", key:" + hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index+hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println(word +" found at location: "+ newIndex);
                return true;
            }
        }
        System.out.println(word +" not found in hasbTable");
        return false;
    }

    public void deleteKeyHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for (int i = index; i<index+hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println(word +" has been deleted from HashTable");
                return;
            }
        }
        System.out.println(word +" not found in HashTable");
    }

    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing(13);
        lp.insertInHashTable("The");
        lp.insertInHashTable("quick");
        lp.insertInHashTable("fox");
        lp.insertInHashTable("over");
        lp.insertInHashTable("brown");
        lp.displayHashTable();
    }
}
*/
