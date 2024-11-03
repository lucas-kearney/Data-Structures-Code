package ListNodes;

public class SinglyLinkedListNode {
    
    public SinglyLinkedListNode nextNode;
    public int payload;

    public SinglyLinkedListNode(int value) {
        this.nextNode = null;
        this.payload = value;
    }


    @Override
    public String toString() {
        return String.valueOf(this.payload);
    }
    
}
