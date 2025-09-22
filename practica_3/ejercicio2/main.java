package practica_3.ejercicio2;

public class main {
        public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);
        
        System.out.println("=== JUEGO NORMAL ===");
        juego1.juega();
        
        System.out.println("\n=== JUEGO PAR ===");
        juego2.juega();
        
        System.out.println("\n=== JUEGO IMPAR ===");
        juego3.juega();
    }
    
}
