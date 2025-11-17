package SEGUNDO_PARCIAL.PREGUNTA_2;

public class Cabina {
    private int nroCabina;
    private Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
    }

    public void agregarPersona(Persona p){
        if (personasAbordo == null) {
            personasAbordo = new Persona[4];
        }
        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] == null) {
                personasAbordo[i] = p;
                break;
            }
        }
    }

    public float pesoencabina(){
        float pesoTotal = 0;
        if (personasAbordo != null) {
            for (int i = 0; i < personasAbordo.length; i++) {
                if (personasAbordo[i] != null) {
                    pesoTotal += personasAbordo[i].getPesoPersona();
                }
            }
        }
        return pesoTotal;
    }

    public int cantidadPersonas(){
        int personasMax = 10;
        int contador = 0;
        if (personasAbordo != null) {
            for (int i = 0; i < personasAbordo.length; i++) {
                if (personasAbordo[i] != null) {
                    contador++;
                }
            }
        }
        return personasMax - contador;
    }

}
