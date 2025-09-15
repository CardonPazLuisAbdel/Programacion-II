package practica_2.ejercicio1;

public class AlgebraVectorial {
    private double x;
    private double y;
    private double z;

    public AlgebraVectorial() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double productoEscalar(AlgebraVectorial b) {
        return (this.x * b.x) + (this.y * b.y) + (this.z * b.z);
    }

    public AlgebraVectorial productoVectorial(AlgebraVectorial b) {
        double cx = (this.y * b.z) - (this.z * b.y);
        double cy = (this.z * b.x) - (this.x * b.z);
        double cz = (this.x * b.y) - (this.y * b.x);
        return new AlgebraVectorial(cx, cy, cz);
    }

    public double longitud() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public boolean esPerpendicular(AlgebraVectorial b) {
        return this.productoEscalar(b) == 0;
    }

    public boolean esParalelo(AlgebraVectorial b) {
        AlgebraVectorial c = this.productoVectorial(b);
        return (c.x == 0 && c.y == 0 && c.z == 0);
    }

    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double escalar = this.productoEscalar(b) / (b.longitud() * b.longitud());
        return new AlgebraVectorial(b.x * escalar, b.y * escalar, b.z * escalar);
    }

    public double componente(AlgebraVectorial b) {
        return this.productoEscalar(b) / b.longitud();
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

