
                                    /*THIS FILE WILL CONTAIN THE ALGORITHM QUESTIONS*/

<<<<<<< HEAD
=======
import java.util.Scanner;
>>>>>>> f8f834a9743996ede2d633906e062e9a9ca7bc93
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
    public static void main(String[] args) {
<<<<<<< HEAD
        int[] arr =  {5,4,3,2,1};
        insSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
=======
       
>>>>>>> f8f834a9743996ede2d633906e062e9a9ca7bc93
    }
}
