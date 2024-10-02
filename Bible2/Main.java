package Bible2;

public class Main 
{
    public static int maxAge = 72;
    public static void main(String[] args) 
    {
        int trueDisciples = 13;
        makeDisciples(trueDisciples);
    }

    public static void makeDisciples(int trueDisciples)
    {
        int years = 0;
        long pop = 770000000;
        int newDisciples = trueDisciples;
        int perDisciple = 2;
        long babies = 0;
        boolean hasDied = false; 
        
        

        while(newDisciples <= pop)
        {
            years = years + 3;
            if(years % 30 == 0)
            {
                babies = babies + pop / 2;
                System.out.println(" " + babies + " babies born");
            }
            
            if(years >= Main.maxAge && !hasDied)
            {
                pop = pop - (pop / 2);
                System.out.print(" " + "People removed from population " + pop);
                hasDied = true;
            }

            if(years % 18 == 0 && babies > 0)
            {
                pop = pop + babies;
                System.out.println(" " + babies + " babies added to population");
                babies = 0;
            }

            newDisciples = newDisciples * perDisciple;
            System.out.println(years);
            System.out.println(newDisciples);
        }

        if(newDisciples >= pop)
        {
            System.out.println("All disciples made " + pop + " at year " + years);
        }
    }
}
