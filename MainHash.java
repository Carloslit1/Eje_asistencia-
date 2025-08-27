package src.hash;

public class MainHash {
    public static void main(String[] args) {
        // Capacidad pequeña para provocar colisiones (mod división)
        MiHashTable<Integer, String> tabla = new MiHashTable<>(5); // 5 a propósito

        // ADD: solo agregar valores (lo que pediste)
        tabla.add(1, "uno");
        tabla.add(6, "seis");     // 6 % 5 = 1 (colisión con 1)
        tabla.add(11, "once");    // 11 % 5 = 1 (colisión con 1 y 6)
        tabla.add(2, "dos");      // 2 % 5 = 2 (otro bucket)
        tabla.add(7, "siete");    // 7 % 5 = 2 (colisión con 2)
        tabla.add(1, "UNO*");     // misma llave -> se ACTUALIZA

        // Mostrar cómo quedó (lista encadenada por bucket)
        tabla.imprimirTabla();

        // (extra de prueba, por si quieres mirar un valor)
        System.out.println("[get 6] -> " + tabla.get(6)); // debe decir "seis"
    }
}
