package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;
    private Horario horario;
    private List<Estudiante> estudiantes;
    
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    public Biblioteca(String nombre, Horario horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
    
    public List<Autor> getAutores() { return autores; }
    public void setAutores(List<Autor> autores) { this.autores = autores; }
    
    public List<Prestamo> getPrestamos() { return prestamos; }
    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }
    
    public Horario getHorario() { return horario; }
    public void setHorario(Horario horario) { this.horario = horario; }
    
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        if (!autores.contains(libro.getAutor())) {
            autores.add(libro.getAutor());
        }
    }
    
    public void agregarAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
        }
    }
    
    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public String listarLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTA DE LIBROS ===\n\n");
        for (Libro libro : libros) {
            sb.append(libro.toString()).append("\n");
            sb.append("------------------------\n");
        }
        return sb.toString();
    }
    
    public String listarPrestamos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTA DE PRÉSTAMOS ===\n\n");
        for (Prestamo prestamo : prestamos) {
            sb.append(prestamo.toString()).append("\n");
            sb.append("------------------------\n");
        }
        return sb.toString();
    }
    
    public String listarEstudiantes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTA DE ESTUDIANTES ===\n\n");
        for (Estudiante estudiante : estudiantes) {
            sb.append(estudiante.mostrarInfo()).append("\n");
            sb.append("------------------------\n");
        }
        return sb.toString();
    }
}
