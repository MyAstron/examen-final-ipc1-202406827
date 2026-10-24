package cris.sic.examenfinal;

public class ExamenFinal {

    public static void main(String[] args) {
        // 1. Crear 3 canciones distintas
        Cancion c1 = new Cancion("Blinding Lights", 200, "The Weeknd");
        Cancion c2 = new Cancion("Starboy", 230, "The Weeknd");
        Cancion c3 = new Cancion("Save Your Tears", 215, "The Weeknd");

        // Verificación inicial de polimorfismo (Commit 1)
        System.out.println("=== PRUEBA DE POLIMORFISMO ===");
        c1.reproducir();
        c2.reproducir();
        c3.reproducir();
        System.out.println();
    }
}
