import java.util.Scanner;

public class searching {

    static int binSearch(int []arr, int l ,int h,int key){
        if(l==h){
            if(arr[l]==key) return l;
            else return -1;
        }
        else{
            int mid = l + (h-l)/2;
            if(arr[mid] == key)     return mid;
            else if(arr[mid]>key){
                h = mid-1;
                return binSearch(arr,l,h,key);
            }
            else{
                l = mid+1;
                return binSearch(arr,l,h,key);
            }
        }
    }
    public static void main(String[] args) {
        int arr [] = {12,15,17,20};
        System.out.println(binSearch(arr,0,3,19));
    }
}
