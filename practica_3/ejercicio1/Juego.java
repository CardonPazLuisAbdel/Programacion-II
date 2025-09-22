package practica_3.ejercicio1;
import java.util.Random;

public class Juego {
        protected int numeroDeVidas;
    protected int record;
    
    public Juego(int vidas) {
        this.numeroDeVidas = vidas;
        this.record = 0;
    }
    
    public void reiniciaPartida() {
        this.numeroDeVidas = 3;
    }
    
    public void actualizaRecord() {
        record++;
    }
    
    public boolean quitaVida() {
        numeroDeVidas--;
        return numeroDeVidas > 0;
    }
}
