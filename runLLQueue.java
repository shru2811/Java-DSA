class llQue{
    LinkedList list;
    public llQue(){
        list = new LinkedList();
        System.out.println("queue has been created");
    }
    public boolean isEmpty(){
        if(list.head==null)
            return true;
        return false;
    }
    public void enQueue(int value){
        list.insertNode(value,list.size);
        System.out.println("the element is successfully added in the queue");
    }
    public void show(){
        list.traversal();
    }
    public int peek(){
        if(isEmpty())
            return -1;
        else
            return list.head.data;
    }
    public int deQueue(){
        int res = peek();
        list.deleteNode(0);
        return res;
    }
    public void delQueue(){
        list.head=null;
        list.tail = null;
        System.out.println("queue has been successfully deleted");
    }
}

public class runLLQueue {
    public static void main(String[] args) {
        llQue que = new llQue();
        System.out.println(que.isEmpty());
        que.enQueue(78);
        que.enQueue(88);
        que.enQueue(98);
        que.show();
        que.deQueue();
        que.show();
        que.delQueue();
    }
}
