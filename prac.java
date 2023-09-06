
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


    //sum of integers using recursion

    public static int sumInt(int n){
        int res = 0;
        if(n==1){
            return 1;
        }
        res += (n + sumInt(n-1));
        return res;
    }
    public static int sumDigits(int n){
        int res = 0;
        if(n==0){
            return 0;
        }
        res += (n%10 + sumDigits(n/10));
        return res;
    }

    public static int Power(int a,int n){
        if(n<0) return -1;
        int res=1;
        if(n==1){
            return a;
        }
        res *= (a*Power(a,n-1));
        return res;
    }
    public static int GCD(int a,int b){
        if(a==b) return a;
        if(a>b){
            if(b==0) return a;
            return GCD(b,a%b);
        }
        else{
            if(a==0) return b;
            return GCD(a,b%a);
        }
    }

    public static int deci2bin(int n){
        if(n==1) return 1;
        int res=0;

        res += ((n%2) + deci2bin(n/2)*10);
        return res;
    }
    public static int recursiveRange(int num) {
        if(num==0) return 0;
        if(num==1) return 1;
        return num+recursiveRange(num-1);
    }

    public static int productofArray(int A[], int N)
    {
        if(N==0)return 1;
        if(N==1)return A[0] ;
        return A[N-1]*productofArray(A,N-1);
    }
    public static String capitalizeWord(String str){
        if(str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + capitalizeWord(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(capitalizeWord("i love java"));
    }
}
