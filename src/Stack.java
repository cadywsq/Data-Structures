/**
 * @author Siqi Wang siqiw1 on 6/11/16.
 */
public class Stack<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 15;
    private int top;
    private E[] A;

    @SuppressWarnings("unchecked")
    public Stack(int initialCapacity) {
        if (initialCapacity <= 0) {
            A = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            A = (E[]) new Object[initialCapacity];
        }
        // Set the top to be -1, indicating the stack is empty
        top = -1;
    }

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(E e) {
        // check if stack is full
        if (top == A.length - 1) {
            resize(A.length * 2);
        }
        A[top++] = e;
    }

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(A, 0, temp, 0, A.length);
        A = temp;
    }

    @Override
    public E pop() {
        E value = A[top];
        A[top--] = null;
        if (top > 0 && top == A.length / 4) {
            resize(A.length / 2);
        }
        return value;
    }

    @Override
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("Empty");
        }
        return A[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

