import java.util.Queue;

class BST{
    class Node {
        public int value;
        private Node left;
        private Node right;
        public int hieght;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return this.value;
        }

    }
    private Node root;
    int gethieght(Node node) {
        if(node==null)
            return -1;
        return node.hieght;
    }
    boolean isEmpty(){
        return root==null;
    }
    public void display(){
        show(root,"Root node: ");
    }
    private void show(Node node, String details){
        if(node==null){
            return;
        }
        System.out.println(details + node.getValue());
        show(node.left,"left child of "+node.getValue()+" ");
        show(node.right,"right child of "+node.getValue()+" ");
    }
    public void insert(int value){
        root = insertion(root,value);
    }
    private Node insertion(Node node, int value){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if(node.value>value){
            node.left = insertion(node.left,value);
        }
        if(node.value<value){
            node.right = insertion(node.right,value);
        }
        node.hieght = Math.max(gethieght(node.left),gethieght(node.right))+1;
        return node;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if (node == null)
            return true;
        return Math.abs(gethieght(node.left)-gethieght(node.right))<=1 && balanced(node.left) && balanced(node.right) ;
    }
    public void populate(int nums[]){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int mid = start + (end-start)/2;
        insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);
    }
    public void preOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
    public void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

}

public class runBST {
    public static void main(String[] args) {
        BST tree = new BST();
        int[]arr = {1,2,3,4,5,6,7};
        tree.populateSorted(arr);
        tree.display();
    }
}