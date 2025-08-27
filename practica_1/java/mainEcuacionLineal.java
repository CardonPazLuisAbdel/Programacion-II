package practica_1.java;

import java.util.Scanner;

public class mainEcuacionLineal{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese los valores de a, b y c, respectivamente: \n");
        float a = Float.parseFloat(sc.nextLine());
        float b = Float.parseFloat(sc.nextLine());
        float c = Float.parseFloat(sc.nextLine());

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c);

        if (ecuacion.getDisciminante() >0){
            System.out.println("Raiz 1: " + ecuacion.getRaiz1());
            System.out.println("Raiz 2: " + ecuacion.getRaiz2());
        }else if (ecuacion.getDisciminante() == 0){
            System.out.println("Raiz unica: " + ecuacion.getRaiz1());
        }else{
            System.out.println("La ecuacion no tiene raices reales");
        }
    }
}