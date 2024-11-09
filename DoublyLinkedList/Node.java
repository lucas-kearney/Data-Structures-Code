package DoublyLinkedList;

public class Node<T> {
    public Node<T> nextNode;
    public Node<T> preNode;
    public T payload;

    public Node(T payload)
    {
        this.nextNode = null;
        this.preNode = null;
        this.payload = payload;
    }

    public Node<T> clone() {
        Node<T> newNode = new Node<>(payload);
        newNode.payload = this.payload;
        return newNode;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.payload);
    }

    public int compareTo(Node<T> another) {
		if (this.payload instanceof Integer) {
			if ((int)this.payload > (int)another.payload) {
				return 1;
			} else if ((int)this.payload < (int)another.payload) {
				return -1;
			} else {
				return 0;
			}
		} else if (this.payload instanceof String) {
			return ((String)this.payload).compareTo((String)another.payload);
		} else {
			return 0;
		}
	}
}
