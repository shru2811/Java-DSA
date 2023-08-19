                                                /*STACK USING ARRAYS*/
class Stack{
    int[] arr;
    int top;

    public Stack(int size){
        this.arr = new int[size];
        this.top = -1;
        System.out.println("the stack is created with the size of: "+size);
    }
    //function to check whether the stack is empty or not
    public Boolean isEmpty(){                               //space: O(1)   time: O(1)
        if(top == -1){
            return true;
        }
        return false;
    }
    //function to check the stack is overflowing or not.
    public Boolean isFull(){                                //space: O(1)   time: O(1)
        if(arr.length==top+1){
            return true;
        }
        return false;
    }
    //function to push the elements in the stack
    public void push(int data){                             //space: O(1)   time:O(1)
        if(isFull()){
            System.out.println("stack is full, can't push the element");
            return;
        }
        arr[++top]=data;
        System.out.println("element is pushed in the stack");
    }
    public void traverse(){                                 //space: O(1)   time: O(N)
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i=top;i>=0;i--) {
            System.out.println(arr[i]);
        }
    }
    public int pop(){                                       //space: O(1)   time:O(N)
        if(isEmpty()){
            System.out.println("Stack is empty, pop function can't work");
            return -1;
        }
        int res = arr[top--];
        return res;
    }
    //peek the top most element
    public int peek(){                                      //space: O(1)   time: O(1)
        if(isEmpty()){
            System.out.println("Top element doesn't exist, as stack is empty");
            return -1;
        }
        return arr[top];
    }
    public void deleteStack(){                              //space: O(1)   time: O(1)
        arr=null;
        System.out.println("Now the stack is deleted");
    }
}

public class demo2 {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        System.out.println(st.isEmpty());
        st.push(8);
        st.push(7);
        st.push(6);
        st.push(5);
        st.push(4);
        st.traverse();
        System.out.println(st.peek());
        st.deleteStack();
        System.out.println(st.peek());
    }


}
