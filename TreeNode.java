import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class TreeNode {
    String data;                    //data of tree node
    ArrayList<TreeNode> child;         //stores the list of children of that node
    TreeNode(String data){              //constructore to create a treeNode
        this.data = data;
        this.child = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode node){        //to add the nodes in the child arraylist of a parent node
        this.child.add(node);
    }

    public String print(int level){
        String ret;
        ret = "  ".repeat(level) + data +"\n";
        for(TreeNode node: this.child){
            ret += node.print(level+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode animal = new TreeNode("Animal");
        TreeNode Reptile = new TreeNode("Reptile");
        TreeNode Mammal = new TreeNode("Mammal");
        TreeNode Lizard = new TreeNode("Lizard");
        TreeNode Snake = new TreeNode("Snake");
        TreeNode Bird = new TreeNode("Bird");
        TreeNode Equine = new TreeNode("Equine");
        TreeNode Bovine = new TreeNode("Bovine");
        TreeNode Canine = new TreeNode("Canine");

        animal.addChild(Reptile);
        animal.addChild(Mammal);
        Reptile.addChild(Lizard);
        Reptile.addChild(Snake);
        Reptile.addChild(Bird);
        Mammal.addChild(Equine);
        Mammal.addChild(Bovine);
        Mammal.addChild(Canine);

        System.out.println(animal.print(0));
    }
}
