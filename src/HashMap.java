/**
 * @author Siqi Wang siqiw1 on 6/26/16.
 */
public class HashMap<K, V> implements HashTableInterface<K, V> {
    private final int DEFAULT_SIZE = 10;
    private Entry[] entries;

    public HashMap() {
        this.entries = new Entry[DEFAULT_SIZE];
    }

    public HashMap(int capacity) {
        this.entries = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];
        /*
        (1) no collision
        (2) has collision, but the key doesn't exist yet
        (3) has collision, and the key already exists.
         */
        if (entry == null) {
            entries[index] = new Entry(key, value);
        } else {
            // when there is collision, apply separate chaining
            // Attention!
            // as put method sets the entry.next if not exist, if statement is entry.next!= null
            // instead of entry!= null.
            while (entry.getNext() != null && !entry.getKey().equals(key)) {
                entry = entry.getNext();
            }
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                entry.setNext(new Entry<K, V>(key, value));
            }
        }

    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            return false;
        }
        while (entry.getNext() != null && !entry.getKey().equals(key)) {
            entry = entry.getNext();
        }
        if (entry.getKey().equals(key)) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];
        // Attention!
        // as get method returns the entry itself if exists, if statement is entry!= null
        // instead of entry.next!=null.
        while (entry != null && !entry.getKey().equals(key)) {
            entry = entry.getNext();
        }
        return entry == null ? null : entry.getValue();
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];
        V value = null;
        while (entry != null && !entry.getKey().equals(key)) {
            entry = entry.getNext();
        }
        if (entry != null) {
            value = entry.getNext().getValue();
            entry.setNext(null);
        }
        return value;
    }

    private int getIndex(K key) {
        return key.hashCode() % entries.length;
    }
}
