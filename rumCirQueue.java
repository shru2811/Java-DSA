
class CirQueue{
    int arr[];
    int top;
    int front;
    int len;
    public CirQueue(int size){                    //creation of empty queue
        this.arr = new int[size];
        this.top = -1;
        this.front=-1;
        this.len = size;
        System.out.println("the queue is created with size: "+size);
    }
    public boolean isFull(){                        //function to check is queue full
        if(top+1==front){
            return true;
        }
        else if(top==len-1 && front==0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmpty(){                       //function to check is queue empty
        if(top==-1){
            return true;
        }
        return false;
    }

    public void enQueue(int element){
        if(isFull()) {
            System.out.println("the queue is full");
            return;
        }
        if(isEmpty()){
            top = 0;
            front = 0;
        }
        else{
            top = (top+1)%len;
        }
        arr[top] = element;
        System.out.println("successfully inserted");
        return;
    }
    public void show(){
        if(isEmpty()){
            System.out.println("the queue is empty");
            return;
        }

        int i = front;
        while(i!=top){
            System.out.print(arr[i]+"|");
            i=(i+1)%len;
        }
        System.out.println(peekTop());
    }
    public int deQueue(){
        if(isEmpty()){
            System.out.println("empty queue");
            return -1;
        }
        int res = arr[front];
        front = (front+1)%len;
        if(front>top){
            front = top = -1;
        }
        return res;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    public int peekTop(){
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }
    public void delQueue(){
        arr = null;
        System.out.println("deleted whole queue successfully");
    }

}

public class rumCirQueue {
    public static void main(String[] args) {
        CirQueue que = new CirQueue(3);
        System.out.println(que.isEmpty());
        que.enQueue(1);
        que.enQueue(2);
        que.enQueue(3);
        que.show();
        que.deQueue();
        que.show();
        que.enQueue(11);
        que.show();
        System.out.println(que.peek());
    }
}
