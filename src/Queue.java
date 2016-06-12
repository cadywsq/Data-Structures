/**
 * @author Siqi Wang siqiw1 on 6/11/16.
 */
public class Queue<E> implements QueueInterface<E> {
    private E[] A;
    private static final int DEFAULT_CAPACITY = 15;
    private int start; // top index
    private int end; // end index
    private int n; // current number of elements

    @SuppressWarnings("unchecked")
    public Queue() {
        A = (E[]) new Object[DEFAULT_CAPACITY];
        start = 0;
        end = -1;
        n = 0;
    }

    @Override
    public void offer(E e) {
        if (n == A.length) {
            throw new RuntimeException("Queue is full");
        }
        end++; // increase end index
        int index = end % A.length; // wrap around, to form a circular queue.
        A[index] = e;
        n++;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E element = A[start];
        A[start] = null; // make sure to remove the element
        n--;
        start = (start + 1) % A.length; // start index increase
        return element;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return A[start];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }
}
