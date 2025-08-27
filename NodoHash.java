package src.hash;

public class NodoHash<K, V> {
    K key;
    V value;
    NodoHash<K, V> next;

    public NodoHash(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
