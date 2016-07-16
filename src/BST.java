/**
 * @author Siqi Wang siqiw1 on 6/29/16.
 */
public class BST implements BSTInterface {
    private static class Node {
        private int key;
        private double value;
        private Node left, right;

        public Node(int key, double value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BST(Node root) {
        this.root = root;
    }

    @Override
    public boolean find(int key) {
        if (root == null) {
            return false; // tree is empty.
        }
        Node current = root;
        // while no match
        while (current.key != key) {
            if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
            if (current == null) {
                return false; // not found.
            }
        }
        return true; // found.
    }

    @Override
    public void insert(int key, double value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;

        while (true) {
            if (key == current.key) {
                return; // assure all values in BST are unique.
            }
            parent = current;
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } // end of go right or left.
        }
    }

    @Override
    public void delete(int key) {

    }

    @Override
    public void traverse() {

    }
}
