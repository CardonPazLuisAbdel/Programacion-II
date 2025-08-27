package practica_1.java;

public class Estadistica {
    private double[] datos;

    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (int i=0; i < datos.length; i++) {
            suma += datos[i];
        }
        return suma / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double suma = 0.0;
        for (int i=0; i < datos.length; i++) {
            double diferencia = datos[i] - prom;
            suma += diferencia * diferencia;
        }
        double varianza = suma / (datos.length - 1);
        return Math.sqrt(varianza);
    }

}
