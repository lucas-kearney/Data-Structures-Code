public class HashTable {
    
    public int size;
    public List[] table;

    public void HashTableChain(int initialSize) {
        this.size = initialSize;
        this.table = new List[this.size];

        for(int i = 0; i < this.size; i++) {
            this.table[i] = new List();
        }
    }

    public int hashingFunction(int key) {
        return key % this.size;
    }
    
    
    public void insert(int key, String value) {
        int index = hashingFunction(key);
        Node oldNode = this.table[index].Search(key);
        if (oldNode != null) {
            oldNode.Value = value; // If the key exists, update its value
        } else {
            Node newNode = new Node();
            newNode.Key = key;
            newNode.Value = value;
            this.table[index].Append(newNode); // Append the new node to the list
        }
    }

    public void Remove(int key) {
        int index = hashingFunction(key);  // Find the correct bucket using the hash function
        this.table[index].Remove(key); 
    }
    

    public Node Search(int key) {
		int index = hashingFunction(key);
		Node result = this.table[index].Search(key);  // Perform the search on the node at the hashed index
    
    if (result == null) {  // If the result is null (no match found)
        System.out.println("Key " + key + " not found.");
    } else {
        System.out.println("Found node: " + result);  // Print the result if found
    }
    
    return result;
	}

    public void display() {
        int hashLength = this.size;
        
        for(int i = 0; i < hashLength; i++) {
            if(this.table[i].Head == null) {
                System.out.println("Bucket " + i + ": is empty");
            }
            else {
                Node curNode = this.table[i].Head;
                while(curNode != null) {
                    System.out.println("Bucket " + i + ": Key -> " + curNode.Key + ", Value -> " + curNode.Value);
                    curNode = curNode.NextNode;
                }
            }
        }
    }

}
