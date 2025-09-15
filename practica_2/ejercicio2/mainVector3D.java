package practica_2.ejercicio2;

public class mainVector3D {
        public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);

        System.out.println("a + b = " + a.suma(b));
        System.out.println("2 * a = " + a.escalar(2));
        System.out.println("|a| = " + a.longitud());
        System.out.println("Normal de a = " + a.normal());
        System.out.println("a · b = " + a.productoEscalar(b));
        System.out.println("a x b = " + a.productoVectorial(b));
    }
}
