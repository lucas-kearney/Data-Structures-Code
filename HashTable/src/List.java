public class List {
    public Node Head;
	
	public List() {
		this.Head = null;
	}
	
	public int GetLength() {
		int length = 0;
		Node node = this.Head;
		while (node != null) {
			length++;
			node = node.NextNode;
		}
		return length;
	}
	
	public boolean IsEmpty() {
		return this.Head == null;
	}
	
	public void Append(Node node) {
		if (this.IsEmpty()) {
			this.Head = node;
		} else {
			Node cur = this.Head;
			while (cur.NextNode != null) {
				cur = cur.NextNode;
			}
			cur.NextNode = node;
		}
	}
	
	//return the first node has the same key
	public Node Search(int key) {
		Node node = this.Head;
		while (node != null) {
			if (node.Key == key) {
				return node;
			} else {
				node = node.NextNode;
			}
		}
		return null;
	}
	
	public void Remove(int key) {
		if (this.IsEmpty()) {
            System.out.println("List is empty.");
            return;  // Do nothing if the list is empty
        }
    
        // Case 1: If the key to remove is at the head node
        if (this.Head.Key == key) {
            this.Head = this.Head.NextNode;  // Remove the head node by pointing Head to the next node
            return;
        }
    
        // Case 2: Traverse the list to find the node to remove
        Node preNode = this.Head;  // Start with the head node
        Node currentNode = preNode.NextNode;  // The next node
    
        // Loop through the list to find the key
        while (currentNode != null) {
            if (currentNode.Key == key) {
                preNode.NextNode = currentNode.NextNode;  // Bypass the current node
                currentNode.NextNode = null;  // Disconnect the node
                return;  // Node removed, exit the method
            }
            // Move to the next pair of nodes
            preNode = currentNode;
            currentNode = currentNode.NextNode;
        }
    
        // If the key is not found in the list
        System.out.println("Key not found in the list.");
    }
}

