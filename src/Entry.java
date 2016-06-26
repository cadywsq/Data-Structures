/**
 * @author Siqi Wang siqiw1 on 6/26/16.
 */
public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value) {
        this.setKey(key);
        this.setValue(value);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Entry<?, ?> entry = (Entry<?, ?>) o;

        if (key != null ? !key.equals(entry.key) : entry.key != null) {
            return false;
        }
        if (value != null ? !value.equals(entry.value) : entry.value != null) {
            return false;
        }
        return next != null ? next.equals(entry.next) : entry.next == null;

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
