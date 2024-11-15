package AbstractStack;

public class main {
    public static void main(String[] args) {
        System.out.println("Abstraction.");
		Stack stack = new IntListStack();
        Node node = new Node();
        node.Payload = "(1 + 2 + 3) / 3 )";
        stack.Push(node);
        System.out.println("Test payload " + stack.Peek().Payload);
        System.out.println("Stack length: " + stack.GetLength());
        System.out.println("Valid Expression? " + stack.IsExpValid(node));
		
		iStack stack1 = new StackInterfaceList();
        Node node1 = new Node();
        node1.Payload = "(1 + 2 + 4) / (3(4 + 3))";
        stack1.Push(node1);
		System.out.println("Test payload Interface " + stack1.Peek().Payload);
        System.out.println("Stack length: " + stack1.GetLength());
        System.out.println("Valid Expression? " + stack1.IsExpValid(node1));
    }
}
