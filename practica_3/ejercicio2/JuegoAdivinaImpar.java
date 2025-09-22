package practica_3.ejercicio2;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
        public JuegoAdivinaImpar(int vidas) {
        super(vidas);
    }
    
    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            System.out.println("Error: El número debe estar entre 0 y 10");
            return false;
        }
        
        if (numero % 2 != 0) {
            return true;
        } else {
            System.out.println("Error: Debes ingresar un número impar");
            return false;
        }
    }
    
}
