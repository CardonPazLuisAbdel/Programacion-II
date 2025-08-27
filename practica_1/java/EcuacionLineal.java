package practica_1.java;
// Ejercicio 1: Ecuacion Lineal

public class EcuacionLineal {
    private float a;
    private float b;
    private float c;

    public EcuacionLineal(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public float getDisciminante(){
        return (this.b * this.b) - (4 * this.a * this.c);
    }
    public double getRaiz1(){
        return (-this.b + Math.sqrt(getDisciminante())) / (2 * this.a);
    }
        public double getRaiz2(){
        return (-this.b - Math.sqrt(getDisciminante())) / (2 * this.a);
    }
}