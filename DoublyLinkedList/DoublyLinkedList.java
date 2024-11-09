package DoublyLinkedList;

public class DoublyLinkedList<T> {
    public Node<T> header;
    public Node<T> tail;

    public DoublyLinkedList() {
        this.header = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.header == null;
    }

    public int getLength() {
        int length = 0;

        Node<T> node = this.header;
        while(node != null) {
            length++;
            node = node.nextNode;
        }
        return length;
    }

    public void append(Node<T> node) {
        if(isEmpty()) {
            this.header = node;
            this.tail = node;
        }
        else {
            this.tail.nextNode = node;
            node.preNode = this.tail;
            this.tail = node;
            node.nextNode = null;
        }
    }

    public void prepend(Node<T> node) {
        if(isEmpty()) {
            this.header = node; 
            this.tail = node;
        }
        else {
            node.nextNode = this.header;
            this.header.preNode = node;
            this.header = node;
        }
    }

    public boolean insertAfter(Node<T> node, Node<T> preNode) {
        if(preNode == tail) {
            this.append(node);
            return true;
        }
        else if(preNode == null) {
            return false;
        }
        else {
            Node<T> next = preNode.nextNode;
            preNode.nextNode = node;
            node.preNode = preNode;
            node.nextNode = next;
            next.preNode = node;

            return true;
        }
    }

    public boolean insertAhead(Node<T> nextNode, Node<T> node) {
        if(nextNode == this.tail) {
            this.prepend(node);
            return true;
        }
        else if(nextNode == null) {
            return false;
        }
        else {
            Node<T> pre = nextNode.preNode;
            pre.nextNode = node;
            node.nextNode = nextNode;
            nextNode.preNode = node;
            node.nextNode = pre;
            return true;
        }
    }

    public void remove(Node<T> node) {
        if(node == this.header && node == this.tail) {
            this.header = null;
            this.tail = null;
        }      
        else if(node == this.header) {
            Node<T> next = node.nextNode;
            node.nextNode = null;
            next.preNode = null;
            this.header = next;
        }
        else if(node == this.tail) {
            Node<T> pre = node.preNode;
            pre.nextNode = null;   
            node.preNode = null;
            this.tail = pre;
        }
        else {
            node.preNode.nextNode = node.nextNode;
            node.nextNode.preNode = node.preNode;
            node.nextNode = null;
            node.preNode = null;
        }
    }

    public Node<T> search(T value) {
        Node<T> node = this.tail;
        while(node != null) {
            if(node.payload == value) {
                return node;
            }
            node = node.preNode;
        }
        return null;
    }

    
    public void display() {
        Node<T> temp = this.header;
        while (temp != null) {
            System.out.print(temp.payload + " ");
            temp = temp.nextNode;
        }
        System.out.println();
    }

    public void sort() {
        if(this.header == null || header.nextNode == null)
        {
            return;
        }

        Node<T> current = this.header.nextNode;
        while(current != null) {
            Node<T> pre = current.preNode;

            while(pre != null && pre.compareTo(current) > 0)
            {
                pre = pre.preNode;
            }

            if(pre != current.preNode)
            {
                remove(current);
                insertAfter(current, current.preNode);
            }

            current = current.nextNode;

        }
    }

}

