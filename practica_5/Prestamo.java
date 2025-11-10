package practica_5;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(14);
    }

    public void mostrarInfo() {
        System.out.println("Prestamo:\n Libro: " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")");
        System.out.println(" Estudiante: " + estudiante.getNombre());
        System.out.println(" Fecha prestamo: " + fechaPrestamo + " - Fecha devolucion: " + fechaDevolucion);
    }
}
