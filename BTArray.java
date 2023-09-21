public class BTArray {

    String arr[];
    int lastUsedInd;
    BTArray(int size){
        arr = new String[size+1];
        this.lastUsedInd = 0;
        System.out.println("The Blank tree of size "+size+" is created");
    }

    boolean isFull(){
        if(lastUsedInd == arr.length-1)
            return true;
        return false;
    }

    void insertNode(String val){
        if(!isFull()){
            arr[++lastUsedInd] = val;
            System.out.println("The node is inserted successfully");
            return;
        }
        System.out.println("The Binary Tree is full");
    }

    void preOrder(int ind){
        if(ind>lastUsedInd) return;
        System.out.print(arr[ind]+" ");
        preOrder(ind*2);
        preOrder(ind*2+1);
    }

    void postOrder(int ind){
        if(ind>lastUsedInd) return;
        postOrder(ind*2);
        postOrder(ind*2+1);
        System.out.print(arr[ind]+" ");
    }

    void inOrder(int ind){
        if(ind>lastUsedInd) return;
        inOrder(ind*2);
        System.out.print(arr[ind]+" ");
        inOrder(ind*2+1);
    }

    void levelOrder(){
        for(int i=1;i<=lastUsedInd;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }

    void delete(String val){
        int loc = search(val);
        if(loc==-1)
            return;
        arr[loc] = arr[lastUsedInd--];
        System.out.println("deletion complete");
    }

    void delEntireTree(){
        try{
            arr=null;
            System.out.println("deletion done");
        }
        catch(Exception e){
            System.out.println("something went wrong, deletion won't occur");
        }
    }
    int search(String val){
        for(int i=1;i<=lastUsedInd;i++){
            if(val==arr[i]){
                System.out.println("element found at: "+i);
                return i;
            }
        }
        System.out.println("element not found");
        return -1;
    }
    public static void main(String[] args) {
        BTArray bt = new BTArray(9);
        bt.insertNode("n1");
        bt.insertNode("n2");
        bt.insertNode("n3");
        bt.insertNode("n4");
        bt.insertNode("n5");
        bt.insertNode("n6");
        bt.insertNode("n7");
        bt.insertNode("n8");
        bt.insertNode("n9");

        bt.preOrder(1);
        System.out.println();
        bt.postOrder(1);
        System.out.println();
        bt.inOrder(1);
        System.out.println();
        bt.levelOrder();
        bt.search("n10");

        bt.delete("n5");
        bt.levelOrder();
        bt.delEntireTree();
        bt.levelOrder();
    }
}
