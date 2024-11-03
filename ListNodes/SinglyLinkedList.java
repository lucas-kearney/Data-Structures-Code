package ListNodes;

public class SinglyLinkedList {
    
    public SinglyLinkedListNode header;
    public int length;

    public SinglyLinkedList() {
        this.header = null; 
        this.length = 0;
    }

    public int getLength() {
        SinglyLinkedListNode node = this.header;
    while(node != null) {
        node = node.nextNode;
    }
    return this.length;
    }



    public boolean isEmpty() {
        return this.header == null;
    }


    public void append(int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        if(this.isEmpty()) {
            this.header = newNode;
            this.length++;
        }
        else {
            SinglyLinkedListNode tail = this.header;
            while(tail.nextNode != null) {
                tail = tail.nextNode;
            }
            tail.nextNode = newNode;
            this.length++;
        }
    }

    public void prepend(int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        newNode.nextNode = this.header;
        this.header = newNode;
        this.length++;
    }

    public void insertAfter(SinglyLinkedListNode a, int value) {
        SinglyLinkedListNode b = a.nextNode;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        a.nextNode = newNode;
        newNode.nextNode = b;
        this.length++;
    }


    public boolean remove(SinglyLinkedListNode node) {
        if(this.isEmpty()) {
            return false;
        }
        else {
            if(this.header == node) {
                if(this.header.nextNode == null) {
                this.header = null;
                this.length = 0;
                }
            
            else {
                this.header = this.header.nextNode;
                this.length--;
            }
            node.nextNode = null;
            return true;
            }
            else {
                SinglyLinkedListNode previous = this.header;
                while(previous.nextNode != null) {
                    if(previous.nextNode == node) {
                        previous.nextNode = previous.nextNode.nextNode;
                        this.length--;
                        node.nextNode = null;
                        return true;
                    }
                    else {
                        previous = previous.nextNode;
                    }
                }
                return false;
            }
        }
    }

    public SinglyLinkedListNode search(int value) {
        SinglyLinkedListNode node = this.header;
        while(node != null) {
            if(node.payload == value) {
                return node;
            }
            else {
                node = node.nextNode;
            }
        }
        return null;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "(0){empty}";
        }
        SinglyLinkedListNode node = this.header;
        String output = "(" + this.getLength() + ")" + "{" + node;
        node = this.header.nextNode;
        while(node != null) {
            output = output + ", " + node;
            node = node.nextNode;
        }
        output = output + "}";
        return output;
    }


    public void printReverse() {
        if(this.isEmpty()) {
            System.out.println("(0){empty}");
        }
        SinglyLinkedListNode node = this.header;
        String output = node.toString();
        node = this.header.nextNode;
        while(node != null) {
            output = node + "< " + output;
            node = node.nextNode;
        }
        System.out.println(String.format("(%d){%s}", this.getLength(), output));
    }


    public void sort(boolean ascending) {
        if (this.header != null) {
            this.header = mergeSort(this.header, ascending);
        }
    }

    public SinglyLinkedListNode mergeSort(SinglyLinkedListNode head, boolean ascending) {
        // Base case: if head is null or only one node
        if (head == null || head.nextNode == null) {
            return head;
        }

        // Get the middle of the list
        SinglyLinkedListNode middle = getMiddle(head);
        SinglyLinkedListNode nextOfMiddle = middle.nextNode;

        // Split the list into two halves
        middle.nextNode = null;

        // Recursively sort the two halves
        SinglyLinkedListNode left = mergeSort(head, ascending);
        SinglyLinkedListNode right = mergeSort(nextOfMiddle, ascending);

        // Merge the sorted halves
        return ascending ? mergeAscending(left, right) : mergeDescending(left, right);
    }

    private SinglyLinkedListNode getMiddle(SinglyLinkedListNode head) {
        if (head == null) return head;

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.nextNode;

        // Move fast two nodes and slow one node
        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        return slow; // Slow is now at the middle
    }

    public SinglyLinkedListNode mergeAscending(SinglyLinkedListNode L1, SinglyLinkedListNode L2) {
        SinglyLinkedListNode sortedTemp = new SinglyLinkedListNode(0); // Temporary head
        SinglyLinkedListNode currentNode = sortedTemp;

        while (L1 != null && L2 != null) {
            if (L1.payload < L2.payload) {
                currentNode.nextNode = L1;
                L1 = L1.nextNode;
            } else {
                currentNode.nextNode = L2;
                L2 = L2.nextNode;
            }
            currentNode = currentNode.nextNode; // Move to the next node
        }

        // Attach any remaining nodes
        if (L1 != null) {
            currentNode.nextNode = L1;
        } else {
            currentNode.nextNode = L2;
        }

        return sortedTemp.nextNode; // Return the merged sorted list
    }

    public SinglyLinkedListNode mergeDescending(SinglyLinkedListNode L1, SinglyLinkedListNode L2) {
        SinglyLinkedListNode sortedTemp = new SinglyLinkedListNode(0); // Temporary head
        SinglyLinkedListNode currentNode = sortedTemp;

        while (L1 != null && L2 != null) {
            if (L1.payload > L2.payload) {
                currentNode.nextNode = L1;
                L1 = L1.nextNode;
            } else {
                currentNode.nextNode = L2;
                L2 = L2.nextNode;
            }
            currentNode = currentNode.nextNode; // Move to the next node
        }

        // Attach any remaining nodes
        if (L1 != null) {
            currentNode.nextNode = L1;
        } else {
            currentNode.nextNode = L2;
        }

        return sortedTemp.nextNode; // Return the merged sorted list
    }

}
