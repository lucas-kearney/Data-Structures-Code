public class Main
{
    public static void main(String[] args) 
    {       
        int n = 14;
        System.out.println(fibSequenceRecursion(n));
        System.out.println(fibSequence(n));
    }

    public static int fibSequenceRecursion(int n)
    {
        if(n == 0)
        {
            return n = 1;
        }
        else if(n == 1)
        {
            return n = 1;
        }
        return fibSequenceRecursion(n - 1) + fibSequenceRecursion(n - 2);
    }


    public static int fibSequence(int n)
    {
        int[] fib = new int[n];
        for(int i = 0; i < n; i++)
        {
            if(i == 0 || i == 1)
            {
                fib[i] = 1;
            }
            else
            {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n - 1] + fib[n - 2];
    }









}