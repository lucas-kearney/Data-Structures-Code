package Bible;

public class Main 
{
    public static void main(String[] args) 
    {
        makeDiscples(13);
        makeDiscplesIn50Years(13);
    }    

    public static void makeDiscples(int trueDisciples)
    {
        int years = 0;
        long pop = 770000000;
        int newDisciples;
        int perDiscpiple = 2;
        newDisciples = trueDisciples;
       
        while(newDisciples * 2 <= pop)
        {
            newDisciples = newDisciples * perDiscpiple;
            years = years + 3; //2 every 3 years
            System.out.println(newDisciples);
            System.out.println(years);
            if(newDisciples * 2 >= pop)//can't go over the max num of ppl
            {
                long limit = pop;
                years = years + 3;
                System.out.println(limit);
                System.out.println(years);
            }
        }

    }

    public static void makeDiscplesIn50Years(int trueDisciples)
    {
        int years = 0;
        long pop = 770000000;
        int newDisciples;
        int perDiscpiple = 3; //how many training per discple
        newDisciples = trueDisciples;
       
        for(int i = years; i <= 50; i = i + 3) //limit on 50 years
        {
            newDisciples = newDisciples * perDiscpiple;
            System.out.println(newDisciples);
            System.out.println(i);
            if(newDisciples * 2 >= pop) // can't train more ppl than there are
            {
                long limit = pop;
                i = i + 3;
                System.out.println(limit);
                System.out.println(i);
                break;
            }
        }

    }
}
