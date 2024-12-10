import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BinarySearchTree tree = new BinarySearchTree();
        
        Random rand = new Random();

        boolean[] inserted = new boolean[10];

        for(int i = 0; i < 10; i++) {
            int num;
            do {
                num = rand.nextInt(10);
            }    
                while(inserted[num]);
                    inserted[num] = true;
                    tree.insert(num);   
            }

        tree.inOrder();

        for(int i = 0; i < 3; i++) {
            int num;
            do {
                num = rand.nextInt(10);
            } while(!inserted[num]);
            inserted[num] = false;
            System.out.println("deleting " + num);
        }

        tree.inOrder();

        for(int i = 0; i < 3; i++) {
            int num = rand.nextInt(10);
            boolean found = tree.search(num);
            System.out.println("search for " + num + ": " + (found ? "Found" : "Not Found"));
        }
    }
}


