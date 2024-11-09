package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        Node<Integer> node1 = new Node<>(7);
        node1.payload = 7;
        Node<Integer> node2 = new Node<>(14);
        node2.payload = 14;
        Node<Integer> node3 = new Node<>(11);
        node3.payload = 11;
        Node<Integer> node4 = new Node<>(3);
        node4.payload = 3;
        Node<Integer> node5 = new Node<>(9);
        node5.payload = 9;
        Node<Integer> node6 = new Node<>(20);
        node6.payload = 20;

        list.append(node1);
        list.append(node2);
        list.insertAfter(node3, node1);
        list.insertAhead(node2, node4);
        list.prepend(node4);
        list.insertAfter(node6, node3);
        list.append(node5);
        list.search(14);
        list.remove(node3);

        //list.display();

        list.sort();
        //list.display();
        
    }
}
