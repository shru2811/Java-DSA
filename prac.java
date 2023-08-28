
                                    /*THIS FILE WILL CONTAIN THE ALGORITHM QUESTIONS*/


public class prac {
    public static void insSort(int[] arr){
        for(int i=1;i<arr.length;i++){              //itterate through the unsorted array
            int j = i-1;                            //
            int key = arr[i];                       //store the unsorted element in this key
            while(j>=0 && arr[j]>key){              //iterate through the sorted array to slide elements to the right so that we can create space for insertion
                arr[j+1]=arr[j];
                j--;                                //where loop terminates we insert element at its place
            }
            arr[j+1]=key;
        }
    }
    public static void conquer(int []arr,int si,int mid,int ei){

    }
    public static void divide(int []arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static int fibonacci(int n){
        if(n==0 || n==1) return n;
        else{
            int res = fibonacci(n-1) + fibonacci(n-2);
            return res;
        }
    }
    public static void main(String[] args) {

        System.out.println(fibonacci(0));
    }
}
