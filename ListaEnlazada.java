package src.hash;

public class ListaEnlazada<K, V> {
    private NodoHash<K, V> cabeza;

    // add "modo estudiante": si la llave existe, actualizo; si no, inserto al inicio
    public void addOrUpdate(K key, V value) {
        NodoHash<K, V> aux = cabeza;
        while (aux != null) {
            if ((key == null && aux.key == null) || (key != null && key.equals(aux.key))) {
                aux.value = value; // actualizar
                return;
            }
            aux = aux.next;
        }
        // insertar al frente
        NodoHash<K, V> nuevo = new NodoHash<>(key, value);
        nuevo.next = cabeza;
        cabeza = nuevo;
    }

    public V get(K key) {
        NodoHash<K, V> aux = cabeza;
        while (aux != null) {
            if ((key == null && aux.key == null) || (key != null && key.equals(aux.key))) {
                return aux.value;
            }
            aux = aux.next;
        }
        return null;
    }

    public boolean isEmpty() { return cabeza == null; }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("vacío");
            return;
        }
        NodoHash<K, V> aux = cabeza;
        System.out.print("cabeza→ ");
        while (aux != null) {
            System.out.print("[" + aux.key + ":" + aux.value + "] ");
            if (aux.next != null) System.out.print("-> ");
            aux = aux.next;
        }
        System.out.println("←fin");
    }
}
