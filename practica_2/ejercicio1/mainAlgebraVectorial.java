package practica_2.ejercicio1;

public class mainAlgebraVectorial {
        public static void main(String[] args) {
        AlgebraVectorial a = new AlgebraVectorial(1, 2, 3);
        AlgebraVectorial b = new AlgebraVectorial(2, 4, 6);
        AlgebraVectorial c = new AlgebraVectorial(-3, 6, -3);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);
        System.out.println("Vector c = " + c);

        System.out.println("¿a , c? " + a.esPerpendicular(c));
        System.out.println("¿a , b? " + a.esParalelo(b));

        System.out.println("Proyección de a sobre b = " + a.proyeccion(b));
        System.out.println("Componente de a en b = " + a.componente(b));
    }
}
