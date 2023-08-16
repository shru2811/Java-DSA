
                                    /*THIS FILE CONTAINS DATA STRUCTURES QUESTIONS ON LINKED LIST*/

import java.util.HashSet;
class Node {
    public int data;
    public Node next;
}

class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next=null;
        head = newNode;
        tail = newNode;
        size=1;
    }
    public void insertNode(int data, int loc){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next=null;
        if (head==null) {
            createLL(data);
            return;
        } else if (loc==0) {
            newNode.next = head;
            head=newNode;
        } else if (loc>=size-1) {
            tail.next = newNode;
            newNode.next=null;
            tail=newNode;
        }else {
            Node temp = head;
            for(int i=0;i<loc-1;i++){
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next = newNode;
        }
        size++;
    }
    public void traversal(){
        Node temp = head;
        while(temp!=null){
            if(temp.next==null){
                System.out.println(temp.data);
            }
            else {
                System.out.print(temp.data + " -> ");
            }
            temp=temp.next;
        }
    }

    public Boolean search(int num){
        Node temp = head;
        for(int i=0;i<size;i++){
            if(temp.data==num) return true;
            temp=temp.next;
        }
        return false;
    }
    public void deleteNode(int loc){
        if(head==null){
            System.out.println("no nodes in this linkedlist");
        } else if (loc==0) {
            if(size==1){
                head.next=null;
                head=null;
                tail=null;
                size--;
                return;
            }
            head=head.next;
            size--;
            return;
        } else if (loc>=size-1) {
            if(size==1){
                head.next=null;
                head=null;
                tail=null;
                size--;
                return;
            }
            Node temp = head;
            for(int i=0;i<size-1;i++){
                temp = temp.next;
            }
            tail = temp;
            tail.next=null;
            size--;
            return;
        } else {
            Node temp = head;
            for(int i=0;i<loc-1;i++){
                temp = temp.next;
            }
            temp.next=temp.next.next;
            size--;
            return;
        }
    }
    public void deleteDups(){
        Node temp = head;                             //create temp node pointing to head
        HashSet<Integer> hs = new HashSet<>();        //hashset for tracking the duplicates
        int i=0;                                      //tracking the index of nodes
        while(temp!=null){                            //loop till the linkedlist ends
            if(hs.contains(temp.data)){               //check whether the hashset contains the element if yes then delete node
                deleteNode(i);
            }
            else{                                    //else add the element in the hashset
                hs.add(temp.data);
            }
            i++;                                    //increment the index
            temp=temp.next;                         //update temp node
        }
    }

    public int nthToLast(int num){
        int ind = size-num;                         //calculating index from starting
        Node temp = head;                           //initializing a temporary node with head
        for(int i=0;i<ind;i++){                     //iterate to that node
            temp=temp.next;
        }
        return temp.data;                           //return value
    }

    public void partition(int x){
        Node temp = head;                           //initialilize the pointer with head
        tail = head;                                //point tail and head to first node only so that partition of node can be done
        while(temp!=null){                          //loop to iterate through the linkedlist
            Node next = temp.next;                  //create a next node to keep the track of next node
            if(temp.data<x){                        //check node's value is lesser than x then add the node value to the beginning of linkedlist
                temp.next=head;
                head=temp;
            }
            else{                                   //else add it to the last of linkedlist
                tail.next=temp;
                tail=temp;
            }
            temp=next;                              //update to the next
        }
    }
    public LinkedList sumLists(LinkedList ll1,LinkedList ll2){
                                                    //create the first digit
        Node temp = ll1.head;
        int num1=0;
        int i=0;
        while(temp!=null){                          //traversing through the linkedlist and adding the digits to form the number
            num1+=temp.data*Math.pow(10,i);
            i++;
            temp=temp.next;
        }
        i=0;                                        //create second digit we have done this is two differnet loops cuz we cant say the number of digits will be same for all the numbers
        temp=ll2.head;
        int num2=0;
        while(temp!=null){                          //traversing through the linkedlist and adding the digits to form the number
            num2+=temp.data*Math.pow(10,i);
            i++;
            temp=temp.next;
        }
        int ans=num1+num2;                          //add the numbers
        LinkedList ll = new LinkedList();           //create a new linkedlist for result
        i=0;
        while(ans!=0){
            ll.insertNode(ans%10,i);           //insert the digits one by one through insertion at the end of linked list as we need to return the linkedlist with digits in reversed order
            ans=ans/10;
            i++;
        }

        return ll;                                  //return new linkedlist!
    }

}

public class demo {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        ll1.insertNode(8,0);
        ll1.insertNode(5,0);
        ll1.insertNode(2,0);
        ll2.insertNode(4,0);
        ll2.insertNode(1,0);
        ll2.insertNode(3,0);
        ll1.traversal();
        ll2.traversal();
        LinkedList ll = new LinkedList();
        ll=ll.sumLists(ll1,ll2);
        ll.traversal();
        
    }
}
