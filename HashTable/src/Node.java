public class Node {
    public Node NextNode;
	public int Key;
	public String Value;
	
	public Node() {
		this.NextNode = null;
		this.Key = 0;
		this.Value = "";
	}

    @Override
    public String toString() {
        return "Key: " + Key + ", Value: " + Value;
    }
}

