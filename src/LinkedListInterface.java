/**
 * @author Siqi Wang siqiw1 on 6/11/16.
 */
public interface LinkedListInterface<E> {
    void addFirst(E key);

    void insertBefore(E key, E toInsert);

    void addLast(E key);

    void insertAfter(E key, E toInsert);

    void remove(E key);
}
