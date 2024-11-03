package ListNodes;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello, singly linked list");
		SinglyLinkedList list = new SinglyLinkedList();
		list.append(17);
		list.prepend(9);
		list.append(5);
		
		list.sort(false);
		list.print();
    }

}
