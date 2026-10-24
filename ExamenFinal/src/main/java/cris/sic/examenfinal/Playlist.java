package cris.sic.examenfinal;

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

    public void siguiente() {
        if (actual == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        if (actual.getSiguiente() == null) {
            System.out.println("Fin de la lista. No hay siguiente canción.");
            return;
        }
        actual = actual.getSiguiente();
        actual.getDato().reproducir();
    }

    public void anterior() {
        if (actual == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        if (actual.getAnterior() == null) {
            System.out.println("Inicio de la lista. No hay canción anterior.");
            return;
        }
        actual = actual.getAnterior();
        actual.getDato().reproducir();
    }

    public void eliminarActual() {
        if (actual == null) {
            System.out.println("No hay canción seleccionada para eliminar.");
            return;
        }

        Cancion eliminada = actual.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
            actual.setSiguiente(null);
            actual = cabeza;
        } else if (actual == cola) {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
            actual.setAnterior(null);
            actual = cola;
        } else {
            NodoDoble ant = actual.getAnterior();
            NodoDoble sig = actual.getSiguiente();
            ant.setSiguiente(sig);
            sig.setAnterior(ant);
            actual.setAnterior(null);
            actual.setSiguiente(null);
            actual = sig;
        }

        tamanio--;
        System.out.println("Canción eliminada: \"" + eliminada.getTitulo() + "\"");
    }

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
