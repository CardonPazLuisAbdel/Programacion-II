package Biblioteca;

public class Autor {
    private String nombre;
    private String nacionalidad;
    
    public Autor() {}
    
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    
    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autor autor = (Autor) obj;
        return nombre.equals(autor.nombre);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}