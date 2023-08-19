
                            /*THIS FILE CONTAINS STACK USING LINKEDLIST WHERE I USED LINKEDLIST FROM DEMO.JAVA FILE*/
class llstack{
    LinkedList ll;
    public llstack() {
        ll = new LinkedList();
    }
    public void push(int val) {
        ll.insertNode(val, 0);
        System.out.println("Push operation done");          //head will be pointing the top
    }
    public void printStack(){
        ll.traversal();
    }
    public Boolean isEmpty(){
        if(ll==null){
            return true;
        }
        return false;
    }
    public int pop(){
        int res = -1;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            res = ll.head.data;
            ll.deleteNode(0);
        }
        return res;
    }
    public int peek(){
        if(isEmpty()) return -1;
        return ll.head.data;
    }
    public void deleteStack(){
        ll.head=null;
        System.out.println("the Stack is deleted successfully");
    }
}

public class demo3 {
    public static void main(String[] args) {
        llstack stk = new llstack();
        stk.push(90);
        stk.push(80);
        stk.push(70);
        stk.push(60);
        stk.printStack();
        System.out.println(stk.isEmpty());
        System.out.println(stk.pop());
        stk.printStack();
        System.out.println(stk.peek());
        stk.deleteStack();
    }
}
