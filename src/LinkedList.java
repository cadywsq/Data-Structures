/**
 * @author Siqi Wang siqiw1 on 6/10/16.
 */
public class LinkedList<E> implements LinkedListInterface<E> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    @Override
    // insert a new node at the beginning of the list
    public void addFirst(E item) {
        head = new Node<E>(item, head);
    }

    @Override
    public void insertBefore(E key, E toInsert) {
        // if the list is empty
        if (head == null) {
            return;
        }
        // if head has the key
        if (head.data.equals(key)) {
            head.next = new Node(toInsert, head.next);
            return;
        }
        // key is not the head, needs to keep track of previous node of current node.
        Node<E> prev = null;
        Node<E> cur = head;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        // found if, then add new node into next of the previous
        if (prev != null) {
            prev.next = new Node<E>(toInsert, cur);
        }
    }

    @Override
    // insert a new node to the end of the list
    public void addLast(E item) {
        // if the list is empty
        if (head == null) {
            head = new Node<E>(item, null);
        } else {
            // traverse to find the last element
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(item, null);
        }
    }

    @Override
    // find a node containing "key" and insert a new node after it.
    public void insertAfter(E key, E toInsert) {
        // find the location first with the given key
        Node<E> temp = head;
        while (temp.next != null && !temp.data.equals(key)) {
            temp = temp.next;
        }

        // as long as the key is in the list
        if (temp != null) {
            temp.next = new Node<E>(toInsert, temp.next);
        }
    }

    @Override
    // remove the first occurrence of a key from the list
    public void remove(E key) {
        // if the list is empty
        if (head == null) {
            throw new RuntimeException("cannot delete");
        }
        // if the key is found from the head element
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<E> prev = null;
        Node<E> cur = head;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        // if key is not found
        if (cur == null) {
            throw new RuntimeException("cannot delete");
        }
        prev.next = cur.next;
    }
}
