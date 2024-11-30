public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        HashTable newTable = new HashTable();

        newTable.HashTableChain(10);

        newTable.insert(27, "27");
        newTable.insert(12, "12");
        newTable.insert(11, "11");
        newTable.insert(10, "10");
        newTable.insert(7, "7");
        newTable.insert(2, "2");
        newTable.insert(30, "30");
        newTable.insert(17, "17");

        newTable.display();

        newTable.Remove(11);
        newTable.Remove(30);
        System.out.println("");

        newTable.display();

        System.out.println("");
        newTable.Search(2);
        newTable.Search(27);
        newTable.Search(5);
    }
}
