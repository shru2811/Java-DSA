import java.util.Queue;

class AVLTree{
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
    public int height() {
        return gethieght(root);
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
    private Node rotate(Node node){
        if(gethieght(node.left) - gethieght(node.right)>1){
            //left heavy >> ll or lr case
            if(gethieght(node.left.left)-gethieght(node.left.right)>0){
                //LL case >> right rotate
                return rightRotate(node);
            }
            if(gethieght(node.left.left)-gethieght(node.left.right)<0){
                //LR case >> left rotate the left child then right rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(gethieght(node.left) - gethieght(node.right)<-1){
            //right heavy >> rr or rl case
            if(gethieght(node.right.right)-gethieght(node.right.left)>0){
                //RR case >> left rotate
                return leftRotate(node);
            }
            if(gethieght(node.right.right)-gethieght(node.right.left)<0){
                //RL case >> right rotate the right child then left rotate
                node.left = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    private Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.hieght = Math.max(gethieght(p.left),gethieght(p.right)+1);
        c.hieght = Math.max(gethieght(c.left),gethieght(c.right)+1);

        return c;
    }
    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.hieght = Math.max(gethieght(p.left),gethieght(p.right)+1);
        c.hieght = Math.max(gethieght(c.left),gethieght(c.right)+1);

        return c;
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
        return rotate(node);
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
    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return gethieght(N.left) - gethieght(N.right);
    }
    public void delete(int value){
        deleteNode(root,value);
    }
    private Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.value)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.value)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.value = temp.value;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.hieght = Math.max(gethieght(root.left), gethieght(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

}

public class AVL {
    public static void main(String[] args) {
        BST tree = new BST();
        int[]arr = {1,2,3,4,5,6,7};
        tree.populateSorted(arr);
        tree.display();
    }
}

