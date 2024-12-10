public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data) {
            root.left = insertRec(root.left, data);
        }
        else if(data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }
    
    
    private boolean searchRec(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(key > root.data) {
            return searchRec(root.right, key);
        }
        if(key < root.data) {
            return searchRec(root.left, key);
        }
        return searchRec(root.left,key);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if(root != null) {
            inOrderRec(root.left);
            System.out.println(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void remove(int key) {
        removeRec(root, key);
    }

    private Node removeRec(Node node, int key) {
        if(node == null) {
            return null;
        }
        if(key < node.data) {
            node.left = removeRec(node.left, key);
        }
        else if(key > node.data) {
            node.right = removeRec(node.right, key);
        }
        else {
            if(node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                Node minNode = findMin(node.right);
                node.data = minNode.data;
                node.right = removeRec(node.right, minNode.data);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }


}
