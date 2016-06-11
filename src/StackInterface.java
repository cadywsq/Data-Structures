/**
 * @author Siqi Wang siqiw1 on 6/11/16.
 */
public interface StackInterface<E> {
    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();
}
