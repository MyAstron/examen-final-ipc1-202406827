package cris.sic.examenfinal;

/**
 * Lista doblemente enlazada para gestionar la reproducción de canciones.
 * Implementada desde cero sin utilizar colecciones de java.util.
 */
public class Playlist {

    private NodoDoble cabeza;
    private NodoDoble cola;
    private NodoDoble actual;
    private int tamanio;

    public Playlist() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
        this.tamanio = 0;
    }

    /**
     * Inserta una canción al final de la playlist conectando los punteros bidireccionales.
     * Si la lista está vacía, cabeza, cola y actual apuntan al nuevo nodo.
     *
     * @param c Canción a insertar en la lista.
     */
    public void agregarCancion(Cancion c) {
        if (c == null) {
            return;
        }

        NodoDoble nuevo = new NodoDoble(c);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    /**
     * Recorre e imprime la playlist completa de cabeza a cola en consola.
     */
    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }

        System.out.println("=== PLAYLIST (" + tamanio + " canciones) ===");
        NodoDoble temp = cabeza;
        int posicion = 1;
        while (temp != null) {
            Cancion c = temp.getDato();
            System.out.println(posicion + ". \"" + c.getTitulo() + "\" - " + c.getArtista() + " (" + c.getDuracion() + "s)");
            temp = temp.getSiguiente();
            posicion++;
        }
        System.out.println("================================");
    }

    // Métodos de acceso y control de estado
    public NodoDoble getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }

    public void setCola(NodoDoble cola) {
        this.cola = cola;
    }

    public NodoDoble getActual() {
        return actual;
    }

    public void setActual(NodoDoble actual) {
        this.actual = actual;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
