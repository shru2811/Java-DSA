import java.util.LinkedList;
import java.util.Queue;

class BinaryNode{
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;

}
class BinarySearchTree{
    BinaryNode root;
    BinarySearchTree(){
        root = null;
    }
    //Insertion of Node
    private BinaryNode insertion(BinaryNode currNode,int value){
        if(currNode==null && currNode==root){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            root = newNode;
//            System.out.println("Successfully Inserted");
            return root;
        }
        if(currNode==null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
//            System.out.println("Successfully Inserted");
            return newNode;
        }
        else if(value<=currNode.value){
            currNode.left = insertion(currNode.left,value);
            return currNode;
        }else{
            currNode.right = insertion(currNode.right,value);
            return currNode;
        }
    }
    public void insert(int value){
        insertion(root,value);
    }
    //pre-Order traversal
    public void preOrder(BinaryNode node ){
        if(node==null)
            return;

        System.out.print(node.value+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node ){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.value+ " ");
        inOrder(node.right);
    }
    public void postOrder(BinaryNode node ){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+ " ");

    }
    public void levelOrder(){                          //LEVEL ORDER TRAVERSAL
        Queue<BinaryNode> que = new LinkedList<BinaryNode>();
        que.add(root);
        while(!que.isEmpty()){
            BinaryNode presentNode = que.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left!=null)
                que.add(presentNode.left);
            if(presentNode.right!=null)
                que.add(presentNode.right);
        }
        System.out.println();
    }
    public BinaryNode search(BinaryNode node, int value){
        if(node==null){
            System.out.println("The node is not found in BST");
            return null;
        }else if(node.value == value){
            System.out.println("The node is found in BST");
            return node;
        }else if(node.value<value){
            return search(node.right,value);
        }else{
            return search(node.left,value);
        }
    }
    public void delBST(){
        root = null;
        System.out.println("The BST is successfully deleted!");
    }
    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }
}
public class runBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.preOrder(bst.root);
        System.out.println();
        bst.inOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);
        System.out.println();
        bst.levelOrder();
        bst.search(bst.root, 10);
    }
}
