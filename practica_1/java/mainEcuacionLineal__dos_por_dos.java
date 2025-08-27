package practica_1.java;
import java.util.Scanner;

public class mainEcuacionLineal__dos_por_dos {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese los valores de a, b, c, d, e y f, respectivamente: \n");
        double a = Double.parseDouble(sc.nextLine());
        double b = Double.parseDouble(sc.nextLine());
        double c = Double.parseDouble(sc.nextLine());
        double d = Double.parseDouble(sc.nextLine());
        double e = Double.parseDouble(sc.nextLine());
        double f = Double.parseDouble(sc.nextLine());

        EcuacionLineal__dos_por_dos ecuacion = new EcuacionLineal__dos_por_dos(a, b, c, d, e, f);

        if (ecuacion.tieneSolucion()){
            System.out.println("Valor de x: " + ecuacion.getX());
            System.out.println("Valor de y: " + ecuacion.getY());
        }else{
            System.out.println("La ecuacion no tiene solucion unica");
        }
    }

    
}
