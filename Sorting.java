import java.util.Scanner;
public class Sorting {
    static void merge(int []arr,int l,int mid, int h){
        int n1 = mid-l+1;
        int n2 = h-mid;

        int a[] = new int[n1];
        int b[] = new int[n2];

        for(int i=0;i<n1;i++){
            a[i] = arr[l+i];
        }

        for(int i=0;i<n2;i++){
            b[i] = arr[mid+1+i];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2) {
            if (a[i] <= b[j]) arr[k++] = a[i++];

            else arr[k++] = b[j++];
        }

        while(i<n1)
            arr[k++] = a[i++];

        while(j<n2)
            arr[k++] = b[j++];
    }
    static void mergeSort(int []arr,int l,int h){
        if(l<h){
            int mid = l + (h-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,h);
            merge(arr,l,mid,h);
        }

    }
    public static void main(String[] args) {
        int arr[] = {89, 45, 23, 67, 78};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
