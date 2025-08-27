package src.hash;

@SuppressWarnings("unchecked")
public class MiHashTable<K, V> {
    private ListaEnlazada<K, V>[] tabla;
    private final int M; // capacidad (mejor primo para mod)

    public MiHashTable(int capacidad) {
        this.M = capacidad;
        this.tabla = (ListaEnlazada<K, V>[]) new ListaEnlazada[M];
        for (int i = 0; i < M; i++) {
            tabla[i] = new ListaEnlazada<>();
        }
    }

    // Hash por división: index = |hashCode(key)| % M
    private int hash(K key) {
        int h = (key == null) ? 0 : key.hashCode();
        if (h < 0) h = -h;
        return h % M;
    }

    // Lo que pediste: ADD (agregar/actualizar)
    public void add(K key, V value) {
        int idx = hash(key);
        tabla[idx].addOrUpdate(key, value);
        System.out.println("[Hash] add(" + key + ", " + value + ") -> bucket " + idx);
    }

    // (extra útil para probar)
    public V get(K key) {
        int idx = hash(key);
        return tabla[idx].get(key);
    }

    public void imprimirTabla() {
        System.out.println("\n== Estado de la tabla ==");
        for (int i = 0; i < M; i++) {
            System.out.print("[" + i + "] ");
            tabla[i].mostrar();
        }
        System.out.println("=========================\n");
    }
}
