package MergeSort;

import java.util.Random;
import java.util.Arrays;

public class Main 
{
    public static void main(String[] args) 
    {
        int[] randomArr = randomizedArray(10, 1, 10);

        int[] mergeSortArr = Arrays.copyOf(randomArr, randomArr.length);
        int[] mergeSortNoTempArr = Arrays.copyOf(randomArr, randomArr.length);
        

        display(randomArr);
        long begin = System.currentTimeMillis();
        mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        long finish = System.currentTimeMillis();
        long totalTime = finish - begin;
        System.out.println("It took mergeSort " + totalTime + " ms");
        display(mergeSortArr);
   

        long begin1 = System.currentTimeMillis();
        mergeSortNoTemp(mergeSortNoTempArr, 0, mergeSortNoTempArr.length - 1);
        long finish1 = System.currentTimeMillis();
        long totalTime1 = finish1 - begin1;
        System.out.println("It took mergeSortNoTemp " + totalTime1 + " ms");
        display(mergeSortNoTempArr);
    }

    

    public static void mergeSort(int[] arr, int begin, int end)
    {
        if(begin < end)
	    {
	        //redefining variables and splitting up the array 
	        int end1 = (begin + end)/2;
	        int begin2 = end1 + 1;
	        int end2 = end;
	        int begin1 = begin;
	        //using recursion to continue running until trivially sorted
	        mergeSort(arr, begin1, end1);
	        mergeSort(arr, begin2, end2);
	        //summoning the sorter
	        merge(arr, begin1, end1, begin2, end2);
	    }
    }
    public static void merge(int[] arr, int begin1, int end1, int begin2, int end2)
    {
        int num1 = end1 - begin1 + 1;
        int num2 = end2 - begin2 + 1;

        int[] leftArray = new int[num1];
	    int[] rightArray = new int[num2];

        for(int i = 0; i < num1; i++)
	    {
	        leftArray[i] = arr[begin1 + i];
	    }
	    
	    for(int j = 0; j < num2; j++)
	    {
	        rightArray[j] = arr[begin2 + j];
	    }

        int i = 0;
        int j = 0;
        int k = begin1;

        while(i < num1 && j < num2)
	    {
	        if(leftArray[i] <= rightArray[j]) //checking the values
	        {
	            arr[k] = leftArray[i]; //placing the lowest value in bucket k
	            i++;                  //then going through the index again with ++
	            
	        }
	        else
	        {
	            arr[k] = rightArray[j];
	            j++;
	        }
	        k++;
	    }
	    
	    while(i < num1) //staying within index
	    {
	        arr[k] = leftArray[i]; //taking the sorted values and permanently changing them
	        i++;
	        k++;
	    }
	    
	    while(j < num2)
	    {
	        arr[k] = rightArray[j];
	        j++;
	        k++;
	    }
    }

    public static void mergeSortNoTemp(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            mergeNoTemp(arr, begin, mid, end);
        }
    }

    public static void mergeNoTemp(int[] arr, int begin, int mid, int end) {
        int start2 = mid + 1;

        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2]) {
            return;
        }

        while (begin <= mid && start2 <= end) {
            if (arr[begin] <= arr[start2]) {
                begin++;
            } else {
                int value = arr[start2];
                int index = start2;

                // Shift all elements between begin and start2 right by one
                while (index != begin) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[begin] = value;

                // Update all pointers
                begin++;
                mid++;
                start2++;
            }
        }
    }


    



    public static int[] randomizedArray(int size, int start, int end)
    {
        Random random = new Random();
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(end - start) + start;
        }

        return randomArray;
    }


    public static void display(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
}
