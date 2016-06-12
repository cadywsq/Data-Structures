/**
 * @author Siqi Wang siqiw1 on 6/11/16.
 */
public interface QueueInterface<E> {
    void offer(E e);

    E poll();

    E peek();

    boolean isEmpty();
}
