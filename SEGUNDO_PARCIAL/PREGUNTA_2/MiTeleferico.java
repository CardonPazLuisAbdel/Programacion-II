package SEGUNDO_PARCIAL.PREGUNTA_2;

public class MiTeleferico {
    private Linea[] lineas;
    private float cantidadIngresos;

    public MiTeleferico() {
        this.lineas = new Linea[3];
        this.cantidadIngresos = 0;
    }

    public void agregarPersonaFila(Persona p, String linea){
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null && lineas[i].getColor().equals(linea)) {
                lineas[i].agregarPersona(p);
                break;
            }
        }
    }

    public void agregarCabina(String linea){
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null && lineas[i].getColor().equals(linea)) {
                Cabina c = new Cabina(lineas[i].getCantidadCabinas() + 1);
                lineas[i].agregarCabina(c);
                break;
            }
        }
    }

    public float ingresosPreferencial(Persona p, String linea){
        float tarifaPreferencial = 1.5f;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null && lineas[i].getColor().equals(linea)) {
                lineas[i].esPreferencial(p);
                cantidadIngresos = cantidadIngresos + tarifaPreferencial;
                break;
            }
        }
        return cantidadIngresos;
    }

    public float ingresosNoPreferencial(Persona p, String linea){
        int tarifaRegular = 3;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null && lineas[i].getColor().equals(linea)) {
                lineas[i].esPreferencial(p);
                cantidadIngresos = cantidadIngresos + tarifaRegular;
                break;
            }
        }
        return cantidadIngresos;
    }

    public void mostrarCabinas(){
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                System.out.println("Linea: " + lineas[i].getColor() + " - Cantidad de Cabinas: " + lineas[i].getCantidadCabinas());
            }
        }
    }


}
