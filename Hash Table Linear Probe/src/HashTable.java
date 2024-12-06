import java.util.Random;

public class HashTable {

    public int size;
    public int numElements;
    public Entry[] table;

    // Define an Entry class to store key-value pairs
    static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int initialSize) {
        this.size = initialSize;
        this.table = new Entry[this.size];
        this.numElements = 0; // Track the number of elements in the table
    }

    // Hash function to map the key to an index
    public int hashingFunction(int key) {
        return key % this.size;
    }

    // Insert a key-value pair
    public void insert(int key, String value) {
        // Check if resizing is needed (Load factor > 0.7)
        if (numElements >= size * 0.7) {
            resize();
        }

        int index = hashingFunction(key);

        // Linear probing: check for empty spot or collision
        while (table[index] != null && table[index].key != key) {
            index = (index + 1) % this.size; // Wrap around using modulus
        }

        // If the slot is empty or the key is the same, insert/update the entry
        if (table[index] == null) {
            numElements++; // Increase the element count
        }
        table[index] = new Entry(key, value);
    }

    // Resize the hash table when the load factor exceeds 0.7
    public void resize() {
        // Double the table size and rehash all existing entries
        System.out.println("Resizing table...");
        size = size * 2;
        Entry[] oldTable = table;
        table = new Entry[size];
        numElements = 0;

        // Rehash and insert all existing entries
        for (Entry entry : oldTable) {
            if (entry != null) {
                insert(entry.key, entry.value);
            }
        }
    }

    // Remove a key-value pair
    public void remove(int key) {
        int index = hashingFunction(key);

        // Linear probing: find the key to remove
        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = null; // Remove by setting it to null
                numElements--;
                return;
            }
            index = (index + 1) % this.size; // Wrap around using modulus
        }

        System.out.println("Key " + key + " not found for removal.");
    }

    // Search for a key-value pair
    public Entry search(int key) {
        int index = hashingFunction(key);

        // Linear probing: find the key
        while (table[index] != null) {
            if (table[index].key == key) {
                return table[index]; // Return the entry if found
            }
            index = (index + 1) % this.size; // Wrap around using modulus
        }

        System.out.println("Key " + key + " not found.");
        return null;
    }

    // Display the table content in a readable format
    public void display() {
        System.out.println("Hash Table Contents:");
        for (int i = 0; i < this.size; i++) {
            if (table[i] != null) {
                System.out.println("Bucket " + i + ": Key -> " + table[i].key + ", Value -> " + table[i].value);
            } else {
                System.out.println("Bucket " + i + ": is empty");
            }
        }
    }

    // Generate a random number
    public static int genRand() {
        Random rand = new Random();
        return rand.nextInt(50);  // Generate a random number between 0 and 49
    }

    public static void main(String[] args) {
        // Initialize the hash table with a size of 10
        HashTable ht = new HashTable(10);

        // Insert 10 random key-value pairs into the hash table
        for (int i = 0; i < 10; i++) {
            int randKey = genRand();
            String randValue = "Value for " + randKey;
            ht.insert(randKey, randValue);  // Insert random key-value pair
        }

        // Display the hash table content
        ht.display();

        // Remove one or two keys
        ht.remove(10); // Try to remove a key that may exist
        ht.remove(25); // Try removing another key

        // Display the hash table after removal
        ht.display();

        // Search for two keys and print the results
        Entry result1 = ht.search(15); // Search for key 15
        if (result1 != null) {
            System.out.println("Search result for key 15: " + result1.value);
        }

        Entry result2 = ht.search(7); // Search for key 7
        if (result2 != null) {
            System.out.println("Search result for key 7: " + result2.value);
        }
    }
}