import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class BTreeNode{
    String value;
    BTreeNode left;
    BTreeNode right;
    int height;
}
public class BinaryTree {
    BTreeNode root;
    BinaryTree(){
        this.root = null;
        System.out.println("root node created and initialized null");
    }

    static void preOrder(BTreeNode node){           //PRE ORDER TRAVERSAL
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(BTreeNode node){           //IN ORDER TRAVERSAL
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    static void postOrder(BTreeNode node){         //POST ORDER TRAVERSAL
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");

    }

    void levelOrder(){                          //LEVEL ORDER TRAVERSAL
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();
        que.add(root);
        while(!que.isEmpty()){
            BTreeNode presentNode = que.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left!=null)
                que.add(presentNode.left);
            if(presentNode.right!=null)
                que.add(presentNode.right);
        }
        System.out.println();
    }

    void search(String value){
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();             //SEARCHING THE NODE IN TREE
        que.add(this.root);
        while(!que.isEmpty()) {
            BTreeNode presentNode = que.remove();
            if (presentNode.value == value) {
                System.out.println("The element is found");
                return;
            }
            if (presentNode.left != null)
                que.add(presentNode.left);
            if (presentNode.right != null)
                que.add(presentNode.right);
        }
        System.out.println("element not found");
    }

    void insertNode(String value){                              //INSERT A NODE IN TREE
        BTreeNode newNode = new BTreeNode();
        newNode.value = value;
        if(root==null){
            root=newNode;
            System.out.println("inserted at root");
            return;
        }
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();
        que.add(this.root);
        while(!que.isEmpty()) {
            BTreeNode presentNode = que.remove();
            if (presentNode.left==null) {
                presentNode.left=newNode;
                System.out.println("Insertion completed");
                return;
            }
            else if (presentNode.right == null){
                presentNode.right=newNode;
                System.out.println("Insertion completed");
                return;
            }
            else{
                que.add(presentNode.left);
                que.add(presentNode.right);
            }
        }

    }

    public BTreeNode getDeepest(){
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();
        que.add(root);
        BTreeNode presentNode = null;
        while(!que.isEmpty()){
            presentNode = que.remove();
            if(presentNode.left!=null)
                que.add(presentNode.left);
            if(presentNode.right!=null)
                que.add(presentNode.right);
        }
        return presentNode;
    }

    void deleteDeepNode(){
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();
        que.add(root);
        BTreeNode presentNode = null;
        BTreeNode previousNode=null;
        while(!que.isEmpty()){
            previousNode = presentNode;
            presentNode = que.remove();
            if(presentNode.left==null){
                previousNode.right = null;
                return;
            }
            else if(presentNode.right==null) {
                presentNode.left = null;
                return;
            }
            que.add(presentNode.left);
            que.add(presentNode.right);
        }
    }

    //delete any node
    void deleteNode(String val){
        Queue<BTreeNode> que = new LinkedList<BTreeNode>();
        que.add(root);
        BTreeNode presentNode = null;
        while(!que.isEmpty()){
            presentNode = que.remove();
            if(presentNode.value == val){
                presentNode.value = getDeepest().value;
                deleteDeepNode();
                System.out.println("deletion successfull");
                return;
            }
            else{
                if(presentNode.left!=null)
                    que.add(presentNode.left);
                if(presentNode.right!=null)
                    que.add(presentNode.right);
            }
        }
        System.out.println("Node with the given value doesn't exist");
    }

    void delBinTree(){
        root = null;
        System.out.println("deleted the whole binary tree");
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insertNode("n1");
        bt.insertNode("n2");
        bt.insertNode("n3");
        bt.insertNode("n4");
        bt.insertNode("n5");
        bt.insertNode("n6");
        bt.levelOrder();
        bt.deleteNode("n4");
        bt.levelOrder();
        bt.deleteNode("n4");
        bt.delBinTree();

    }
}
