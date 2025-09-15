package practica_2.ejercicio2;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D suma(Vector3D b) {
        return new Vector3D(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    public Vector3D escalar(double r) {
        return new Vector3D(this.x * r, this.y * r, this.z * r);
    }

    public double longitud() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D normal() {
        double len = this.longitud();
        if (len == 0) return new Vector3D(0, 0, 0);
        return new Vector3D(this.x / len, this.y / len, this.z / len);
    }

    public double productoEscalar(Vector3D b) {
        return (this.x * b.x) + (this.y * b.y) + (this.z * b.z);
    }

    public Vector3D productoVectorial(Vector3D b) {
        double cx = (this.y * b.z) - (this.z * b.y);
        double cy = (this.z * b.x) - (this.x * b.z);
        double cz = (this.x * b.y) - (this.y * b.x);
        return new Vector3D(cx, cy, cz);
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

