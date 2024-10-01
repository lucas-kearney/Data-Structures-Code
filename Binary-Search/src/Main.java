public class Main
{

    private static int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    private static int key;
    
    public void matrix(int[][] arr, int key)
    {
        Main.arr = arr;
        Main.key = key;
    }
    
    public static int[] BinaryMatrixSearch(int[][] arr, int key)
    {
        int row = arr.length;
        int column = arr[0].length;
        int[] temp = new int[row * column];


        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                int k = 0;
                temp[k] = arr[i][j];
                k++;
            }
        }
        int[] result = search(temp, key);

        for(int l = 0; l < row; l++)
        {
            for(int m = 0; m < column; m++)
            {
                if(arr[l][m] == key)
                {
                    return result;
                }
            }
        }
        return new int[0];       
    }
    
    
    /*int rows = result.length;
    int columns = result[0].length;
    for(int i = 0; i < rows + columns; i++)
    {
    int r = i / columns;
    int c = i % columns;
    }*/

    public static int[] search(int[] temp, int key)
    {
        int start = 0;
        int end = temp.length - 1;
        int mid;

        while(start <= end)
        {
            mid = (start + end) / 2;

            if(temp[mid] == key)
            {
                return temp;
            }
            else if(temp[mid] < key)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return new int[0];      
    }

    public static int[] findKeyPosition(int[][] arr, int key) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == key) {
                    return new int[]{i, j}; // Return the row and column where the key is found
                }
            }
        }
        return new int[]{-1, -1}; // Return -1, -1 if the key is not found
    }



    public static void main(String[] args)
    {
        int key = 6;

        int[] result = BinaryMatrixSearch(arr, key);
        if(result.length == 0 || result.length == 0)
        {
            System.out.println("Key " + key + " not found in the matrix.");
        }
        else 
        {
            System.out.println("Key " + key + " was found at arr[ the value of l and m but I can't figure it out");            
        }   
    }
}