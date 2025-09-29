package practica_4.ejercicio1;

abstract class Empleado {
    protected String nombre;
    
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double CalcularSalarioMensual();
    
    @Override
    public String toString() {
        return "Empleado: " + nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
