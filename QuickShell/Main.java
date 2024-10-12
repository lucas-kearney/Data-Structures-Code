package QuickShell;

import java.util.Random;
import java.util.Arrays;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("hello world");
        
        int[] random = randomizedArray(10000, 1, 10000);
        int[] gapValues = {1000, 500, 250, 100, 50, 20, 10, 1};
       
        int[] arrayForQuick = Arrays.copyOf(random, random.length);
        int[] arrayForShell = Arrays.copyOf(random, random.length);

        long begin1 = System.currentTimeMillis();
        shellSort(arrayForShell, gapValues);
        long finish1 = System.currentTimeMillis();
        long totalTime1 = finish1 - begin1;
        System.out.println("ShellSort finished in " + totalTime1 + "ms");

        long begin = System.currentTimeMillis();
        quickSort(arrayForQuick, 0, arrayForQuick.length - 1);
        long finish = System.currentTimeMillis();
        long totalTime = finish - begin;
        System.out.println("QuickSort finished in " + totalTime + "ms");
        
        
    }

    public static void quickSort(int[] arr, int start, int end)
    {
        
        if(start < end) // base case
        {
            int partIndex = partition(arr, start, end); 

            quickSort(arr, start, partIndex - 1); //reccursive call left side
            quickSort(arr, partIndex + 1, end); //right side
        }
        
    }
    
    
    public static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end]; //making the pivot the end point
        int index = start - 1;

        for(int j = start; j <= end - 1; j++) //finding values less than the pivot
        {
            if(arr[j] < pivot)
            {
                index++;
                swap(arr, index, j);
            }
        }

        swap(arr, index + 1, end);
        return index + 1;

    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i]; //swapping the low index and j
        arr[i] = arr[j];//to partition the lower region and upper
        arr[j] = temp;
    }

    public static void shellSort(int[] arr, int[] gapValues)
    {
        for(int g = 0; g < gapValues.length; g++)
        {
            int gap = gapValues[g];
            for(int i = 0; i < gap; i++)
            {
                insertionSortInterLeaved(arr, i, gap);
            }
        }
    }
    
    public static void insertionSortInterLeaved(int[] arr, int start, int gap)
    {
        for(int i = start + gap; i < arr.length; i += gap)
        {
            int j = i;
            while(j - gap >= start && arr[j] < arr[j - gap])
            {
                int temp = arr[j];
                arr[j] = arr[j - gap];
                arr[j - gap] = temp;
                j -= gap;
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
}
