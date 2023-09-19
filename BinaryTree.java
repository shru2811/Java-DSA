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

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BTreeNode n1 = new BTreeNode();
        n1.value = "n1";
        BTreeNode n2 = new BTreeNode();
        n2.value = "n2";
        BTreeNode n3 = new BTreeNode();
        n3.value = "n3";
        BTreeNode n4 = new BTreeNode();
        n4.value = "n4";
        BTreeNode n5 = new BTreeNode();
        n5.value = "n5";
        BTreeNode n6 = new BTreeNode();
        n6.value = "n6";
        BTreeNode n7 = new BTreeNode();
        n7.value = "n7";
        BTreeNode n8 = new BTreeNode();
        n8.value = "n8";
        BTreeNode n9 = new BTreeNode();
        n9.value = "n9";
        bt.root = n1;

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        System.out.print("pre order traversal: ");
        preOrder(n1);
        System.out.println();
        System.out.print("in order traversal: ");
        inOrder(n1);
        System.out.println();
        System.out.print("post order traversal: ");
        postOrder(n1);
        System.out.println();
        System.out.print("level order traversal: ");
        bt.levelOrder();
        System.out.println();
        bt.insertNode("n10");
        System.out.print("level order traversal: ");
        bt.levelOrder();
        System.out.println();
        BinaryTree bt2 = new BinaryTree();
        bt2.insertNode("m1");
        bt2.levelOrder();
    }
}
