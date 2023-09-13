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
    static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static int partition(int a[],int l,int h){
        int pivot = a[l];
        int i = l;
        int j = h+1;
        while(i<j){
            do{
                i+=1;
            }while(a[i]<pivot && i<h);

            do{
                j-=1;
            }while(a[j]>pivot);
            if(i<=j)
                swap(a,i,j);

        }
        swap(a,l,j);
        return j;
    }


    static void quickSort(int arr[],int l,int h){
        if(l<h){
            int j = partition(arr,l,h);
            quickSort(arr,l,j-1);
            quickSort(arr,j+1,h);
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
