package Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;
    
    public Prestamo() {}
    
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, 
                   Estudiante estudiante, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estudiante = estudiante;
        this.libro = libro;
    }
    
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
    
    @Override
    public String toString() {
        return "Préstamo: " + libro.getTitulo() + 
               "\nEstudiante: " + estudiante.getNombre() +
               "\nFecha Préstamo: " + fechaPrestamo +
               "\nFecha Devolución: " + fechaDevolucion;
    }
}
