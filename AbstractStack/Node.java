package AbstractStack;

public class Node {
    public String Payload;
        public Node NextNode;
        public Node PreNode;
    
        public Node() {
        this.Payload = "";
        this.NextNode = null;
        this.PreNode = null;
    }
}
