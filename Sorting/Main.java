package Sorting;
import java.util.Random;
import java.util.Arrays;

public class Main 
{
    
    
    
    public static void main(String[] args) 
    {
        int[] random = randomizedArray(10000, 1, 10000);
        for(int i = 0; i <= 3; i++)
        {
        shuffleArray(random);
        }
        
        int[] arrayForAlgorithm1 = Arrays.copyOf(random, random.length);
        int[] arrayForAlgorithm2 = Arrays.copyOf(random, random.length);
        int[] arrayForAlgorithm3 = Arrays.copyOf(random, random.length);
        
        bubbleSort(arrayForAlgorithm1);
        selectionSort(arrayForAlgorithm2);
        insertionSort(arrayForAlgorithm3);
    }

    public static void bubbleSort(int[] arr)
    {
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;

        System.out.println("Sorting a random array of size "
                            + arr.length + " took bubbleSort " 
                            + totalTime + "ms to complete.");

        /*System.out.print("Sorted Array: ");
        for(int k = 0; k < arr.length; k++)
        {
            System.out.print(arr[k] + " ");
        }*/
    }

    public static void selectionSort(int[] arr)
    {
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        long finish = System.currentTimeMillis();
        long totalTime = finish - start;

        System.out.println("Sorting a random array of size "
                            + arr.length + " took selectionSort " 
                            + totalTime + "ms to complete.");

        /*System.out.print("Sorted Array: ");
        for(int k = 0; k < arr.length; k++)
        {
            System.out.print(arr[k] + " ");
        }*/
    }

    public static void insertionSort(int[] arr)
    {
        long start = System.currentTimeMillis();

        for(int i = 0; i < arr.length; i++)
        {
            int key = arr[i]; //creating the element we are trying to compare
            int j = i - 1;

            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j]; //pushing the j element back to make room for the i element
                j = j - 1; //basically going backwards to see all the prior values
            }
            arr[j + 1] = key;
        }

        long finish = System.currentTimeMillis();
        long totalTime = finish - start;

        System.out.println("Sorting a random array of size "
                            + arr.length + " took insertionSort " 
                            + totalTime + "ms to complete.");
    }

    public static int[] randomizedArray(int size, int start, int end)
    {
        Random rand = new Random();
        int[] result = new int[size];
        for(int i = 0; i < size; i++)
        {           
            boolean unique;
            int randInt;

            do 
            {
                randInt = rand.nextInt(100000); // Generate random number between 0 and 999
                unique = true;

                for (int j = 0; j < i; j++) 
                {
                    if (result[j] == randInt) 
                    {
                        unique = false;
                        break; // Exit the loop if a duplicate is found
                    }
                }
            } while (!unique); // Move this line outside the inner loop

            result[i] = randInt; // Assign the unique random integer to the result array
            //System.out.println(result[i]);
        } 
            //shuffleArray(result);
            return result;
        }   
        
        

    public static void shuffleArray(int[] arr)
    {
        Random rand = new Random();
        
            for(int i = arr.length - 1; i > 0; i--)
            {
                int k = rand.nextInt(arr.length);

                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
    } //Function was selecting the same value within the array so
    // I am opting not to use it.

}
