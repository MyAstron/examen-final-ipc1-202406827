package cris.sic.examenfinal;

public class ExamenFinal {

    public static void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Cancion c1 = new Cancion("Blinding Lights", 2000, "The Weeknd");
        Cancion c2 = new Cancion("Starboy", 2300, "The Weeknd");
        Cancion c3 = new Cancion("Save Your Tears", 2150, "The Weeknd");

        System.out.println("=== PRUEBA DE POLIMORFISMO ===");
        c1.reproducir();
        c2.reproducir();
        c3.reproducir();
        System.out.println();
        pausar(1500);

        Playlist playlist = new Playlist();
        playlist.agregarCancion(c1);
        playlist.agregarCancion(c2);
        playlist.agregarCancion(c3);

        System.out.println("=== INICIANDO SIMULACION DEL REPRODUCTOR ===");
        playlist.mostrarPlaylist();
        pausar(1500);

        System.out.println("\n-> Ejecutando siguiente():");
        playlist.siguiente();
        pausar(1500);

        System.out.println("\n-> Ejecutando siguiente():");
        playlist.siguiente();
        pausar(1500);

        System.out.println("\n-> Ejecutando anterior():");
        playlist.anterior();
        pausar(1500);

        System.out.println("\n-> Eliminando cancion actual...");
        playlist.eliminarActual();
        pausar(1500);

        System.out.println("\n-> Estado final de la playlist:");
        playlist.mostrarPlaylist();
    }
}
