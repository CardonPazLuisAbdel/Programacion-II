package practica_1.java;

import java.util.Scanner;

public class mainEstadistica {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        double[] num = new double[10];
        System.out.println("Ingrese 10 números: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            String input = sc.next();
            num[i] = Double.parseDouble(input);
        }
        Estadistica estadistica = new Estadistica(num);
        double promedio = estadistica.promedio();
        double desviacion = estadistica.desviacion();
        System.out.println("Promedio: " + String.format("%.2f", promedio));
        System.out.println("Desviación estándar: " + String.format("%.5f", desviacion));

        
    }
}
