package oct_4;

import java.security.KeyStore.Entry;
import java.util.function.BiConsumer;

class HashTable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new Entry[capacity];
        // table = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) { // Check if the key is null to prevent null pointer exceptions
            throw new IllegalArgumentException("Null keys are not allowed"); // Throw an exception if the key is null
        }
        if ((double) size / table.length >= LOAD_FACTOR_THRESHOLD) { // Check if the load factor has exceeded the
                                                                     // threshold
            resize(); // Resize the table if the load factor has exceeded the threshold
        }
        int index = hash1(key); // Calculate the initial index using the first hash function
        int step = hash2(key); // Calculate the step size using the second hash function
        int i = 0; // Initialize the iteration counter
        while (table[index] != null && !table[index].getKey().equals(key)) { // Loop until an empty slot is found or the
                                                                             // key is found
            index = (index + step * i) % table.length; // Calculate the next index using the step size and iteration
                                                       // counter
            i++; // Increment the iteration counter
        }
        table[index] = new Entry<>(key, value); // Insert the new entry into the table
        size++; // Increment the size of the table

    }

    public V get(K key) {
        if (key == null) // Check if the key is null to prevent null pointer exceptions
        {
            throw new IllegalArgumentException("Null keys are not allowed"); // Throw an exception if the key is // null
        }
        int index = hash1(key);
        int step = hash2(key);
        int i = 0;
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + step * i) % table.length;
            i++;
        }
        return null;
    }

    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }

        int index = hash1(key);
        int step = hash2(key);
        int i = 0;

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                // Remove the entry by setting it to null
                table[index] = null;
                size--;

                index = (index + step * i) % table.length;
                i++;

                while (table[index] != null) {
                    Entry<K, V> entryToRehash = table[index];
                    table[index] = null;
                    size--; // Temporarily decrease size to prevent incorrect resizing
                    put(entryToRehash.getKey(), entryToRehash.getValue());
                    index = (index + step * i) % table.length;
                    i++;
                }
                return;
            }
            index = (index + step * i) % table.length;
            i++;
        }
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                action.accept(entry.getKey(), entry.getValue());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        // table = new Entry[oldTable.length * 2];
        table = (Entry<K, V>[]) new Entry[oldTable.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key) {
        return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}

public class HashCreate {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(16);

        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("orange", 3);
        hashTable.forEach((key, value) -> System.out.println(key + " - " + value));

        System.out.println(hashTable.get("apple"));
        hashTable.remove("apple");
        System.out.println(hashTable.get("apple"));
        hashTable.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
