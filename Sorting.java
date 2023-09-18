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

    static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j])
                    min=j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

    }

    static int kadaneAlgo(int arr[]){
        int n= arr.length;
        int maxsum=Integer.MIN_VALUE;
        int cursum = 0;
        int i;
        for(i=0;i<n;i++){
            cursum+=arr[i];
            if(maxsum<cursum)
                maxsum = cursum;
            if(cursum<0)
                cursum=0;
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int arr[] = {1,-7,4,5,3,-1};
        System.out.println(kadaneAlgo(arr));
    }

}
