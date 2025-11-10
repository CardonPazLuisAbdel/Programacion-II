package practica_5;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros; 
    private List<Autor> autores;
    private List<Prestamo> prestamos;
    private Horario horario;

    class Horario {
        private String diasApertura;
        private String horaApertura;
        private String horaCierre;

        public Horario(String diasApertura, String horaApertura, String horaCierre) {
            this.diasApertura = diasApertura;
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public void mostrarHorario() {
            System.out.println("Horario: " + diasApertura + " | " + horaApertura + " - " + horaCierre);
        }
    }

    public Biblioteca(String nombre, String diasApertura, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario(diasApertura, horaApertura, horaCierre);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor registrado: " + autor.getNombre());
    }

    public void prestarLibro(Estudiante estudiante, Libro libro) {
        Prestamo p = new Prestamo(estudiante, libro);
        prestamos.add(p);
        System.out.println("Prestamo creado para libro '" + libro.getTitulo() + "' a " + estudiante.getNombre());
    }


    public void mostrarEstado() {
        System.out.println("\n=== Estado de la Biblioteca: " + nombre + " ===");
        horario.mostrarHorario();

        System.out.println("\nAutores registrados:");
        if (autores.isEmpty()) System.out.println(" Ninguno");
        else for (Autor a : autores) a.mostrarInfo();

        System.out.println("\nLibros disponibles:");
        if (libros.isEmpty()) System.out.println(" Ninguno");
        else for (Libro l : libros) System.out.println(" - " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ")");

        System.out.println("\nPrestamos activos:");
        if (prestamos.isEmpty()) System.out.println(" Ninguno");
        else for (Prestamo pr : prestamos) pr.mostrarInfo();
    }


    public void cerrarBiblioteca() {
        System.out.println("\nCerrando biblioteca " + nombre + "... Los prestamos dejaran de existir.");
        prestamos.clear();
        System.out.println("Todos los prestamos han sido removidos.");
    }
}
