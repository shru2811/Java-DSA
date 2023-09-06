
                                    /*THIS FILE WILL CONTAIN THE recursion questions*/


public class prac {
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
    //sum of digits
    public static int sumDigits(int n){
        int res = 0;
        if(n==0){
            return 0;
        }
        res += (n%10 + sumDigits(n/10));
        return res;
    }
    //power
    public static int Power(int a,int n){
        if(n<0) return -1;
        int res=1;
        if(n==1){
            return a;
        }
        res *= (a*Power(a,n-1));
        return res;
    }
    //greatest common divisor
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
    //convert decimal to binary
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
