public class Stack{
    int[] arr;
    int top;

    public Stack(int size){
        this.arr = new int[size];
        this.top = -1;
        System.out.println("the stack is created with the size of: "+size);
    }
}

public class demo2 {
    Stack st = new Stack(5);

}
