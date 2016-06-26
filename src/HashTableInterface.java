/**
 * @author Siqi Wang siqiw1 on 6/13/16.
 */
public interface HashTableInterface<K, V> {
    void put(K key, V value);

    boolean containsKey(K key);

    V get(K key);

    V remove(K key);
}
