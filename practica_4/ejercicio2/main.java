package practica_4.ejercicio2;
import java.util.Random;
public class main {
    public static void main(String[] args) {
        Random random = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"rojo", "azul", "verde", "amarillo", "naranja"};
        
        for (int i = 0; i < 5; i++) {
            int tipoFigura = random.nextInt(2) + 1;
            String color = colores[random.nextInt(colores.length)];
            
            if (tipoFigura == 1) {
                double lado = 1 + random.nextDouble() * 9;
                figuras[i] = new Cuadrado(color, lado);
            } else {
                double radio = 1 + random.nextDouble() * 9;
                figuras[i] = new Circulo(color, radio);
            }
        }
        
        System.out.println("=== INFORMACIÓN DE FIGURAS ===");
        for (Figura figura : figuras) {
            System.out.println("\n" + figura.toString());
            System.out.println("Área: " + String.format("%.2f", figura.area()));
            System.out.println("Perímetro: " + String.format("%.2f", figura.perimetro()));
            
            if (figura instanceof Coloreado) {
                Coloreado coloreado = (Coloreado) figura;
                System.out.println("Método colorear: " + coloreado.comoColorear());
            } else {
                System.out.println("Esta figura no implementa la interfaz Coloreado");
            }
        }
    }
}
