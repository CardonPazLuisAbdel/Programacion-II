package practica_4.ejercicio2;

abstract class Figura {
    protected String color;
    
    public Figura(String color) {
        this.color = color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        return "Figura [color=" + color + "]";
    }
    
    public abstract double area();
    public abstract double perimetro();
}
