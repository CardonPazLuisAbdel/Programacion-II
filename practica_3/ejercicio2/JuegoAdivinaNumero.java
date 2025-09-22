package practica_3.ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;
    
    public JuegoAdivinaNumero(int vidas) {
        super(vidas);
    }
    
    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }
    
    public void juega() {
        reiniciaPartida();
        Random random = new Random();
        numeroAAdivinar = random.nextInt(11);
        
        Scanner leer = new Scanner(System.in);
        boolean adivinado = false;
        
        System.out.println("Adivina un número entre 0 y 10:");
        
        while (!adivinado && numeroDeVidas > 0) {
            System.out.print("Tu intento: ");
            int intento = leer.nextInt();
            
            if (!validaNumero(intento)) {
                System.out.println("Número no válido. Debe estar entre 0 y 10.");
                continue;
            }
            
            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                adivinado = true;
            } else {
                boolean quedanVidas = quitaVida();
                if (quedanVidas) {
                    if (intento < numeroAAdivinar) {
                        System.out.println("El número es mayor. Te quedan " + numeroDeVidas + " vidas.");
                    } else {
                        System.out.println("El número es menor. Te quedan " + numeroDeVidas + " vidas.");
                    }
                    System.out.print("Intenta de nuevo: ");
                } else {
                    System.out.println("¡Game Over! El número era: " + numeroAAdivinar);
                }
            }
        }
    }
    
}
