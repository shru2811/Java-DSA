
class queueArray{
    int arr[];
    int top;
    int front;
    int len;
    public queueArray(int size){                    //creation of empty queue
        this.arr = new int[size];
        this. top = -1;
        this.front=-1;
        this.len = size;
        System.out.println("the queue is created with size: "+size);
    }
    public boolean isFull(){                        //function to check is queue full
        if(this.top==this.len-1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){                       //function to check is queue empty
        if(this.top==-1){
            return true;
        }
        return false;
    }

    public void enQueue(int element){
        if(this.isFull()) {
            System.out.println("the queue is full");
            return;
        }
        if(this.isEmpty()){
            this.top = 0;
            this.front = 0;
        }
        else{
            this.top++;
        }
        this.arr[top] = element;
        System.out.println("successfully inserted");
        return;
    }
    public void show(){
        if(this.isEmpty()){
            System.out.println("the queue is empty");
            return;
        }
        for(int i=this.front;i<=this.top;i++){
            if(i==this.top){
                System.out.println(this.arr[i]);
                return;
            }
            System.out.print(this.arr[i] + " || ");
        }
    }
    public int deQueue(){
        if(this.isEmpty()){
            System.out.println("empty queue");
            return -1;
        }
        int res = this.arr[this.front++];
        if(this.front>this.top){
            this.front = this.top = -1;
        }
        return res;
    }
    public int peek(){
        if(this.isEmpty()){
            return -1;
        }
        return this.arr[this.front];
    }
    public void delQueue(){
        this.arr = null;
        System.out.println("deleted whole queue successfully");
    }

//    every function here runs on O(1) time complexity and space complexity (only creation takes O(n) space complexity)
}

public class runQueue {
    public static void main(String[] args) {
        queueArray que = new queueArray(5);
        System.out.println(que.isEmpty());
        System.out.println(que.isFull());

        que.enQueue(1);
        que.enQueue(2);
        que.enQueue(3);
        que.enQueue(4);
        que.enQueue(5);
        System.out.println(que.peek());
        que.show();
        System.out.println(que.deQueue());
        System.out.println(que.deQueue());
        System.out.println(que.peek());
        que.delQueue();
        que.enQueue(2);



    }

}
