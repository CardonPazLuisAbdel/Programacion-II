package practica_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // agregacion
        Autor autor1 = new Autor("Gabriel Garcia Marquez", "Colombiana");
        Autor autor2 = new Autor("Jane Austen", "Inglesa");

        // agregacion
        List<String> contenido1 = new ArrayList<>();
        contenido1.add("Cien anios de soledad - pagina 1");
        contenido1.add("Cien anios de soledad - pagina 2");
        Libro libro1 = new Libro("Cien anios de soledad", "ISBN-1001", contenido1);

        List<String> contenido2 = new ArrayList<>();
        contenido2.add("Fuego y Sangre - pagina 1");
        contenido2.add("Fuego y Sangre - pagina 2");
        Libro libro2 = new Libro("Fuego y Sangre", "ISBN-2002", contenido2);

        // composicion
        Biblioteca biblioteca = new Biblioteca("Biblioteca UMSA", "Lun-Vie", "08:00", "18:00");

        // agregacion
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        biblioteca.mostrarEstado();

        // composicion
        libro1.leer();

        // asociacion
        Estudiante est = new Estudiante("2025001", "Maria Perez");
        biblioteca.prestarLibro(est, libro1);

        biblioteca.mostrarEstado();

        biblioteca.cerrarBiblioteca();

        biblioteca.mostrarEstado();
        }
}
