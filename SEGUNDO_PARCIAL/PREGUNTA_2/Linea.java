package SEGUNDO_PARCIAL.PREGUNTA_2;

public class Linea {
    private String color;
    private Persona[] filaPersonas;
    private Cabina[] cabinas;
    private int cantidadCabinas;

    public Linea(String color){
        this.color = color;
    }

    public void agregarPersona(Persona p){
        if (filaPersonas == null) {
            filaPersonas = new Persona[100];
        }
        for (int i = 0; i < filaPersonas.length; i++) {
            if (filaPersonas[i] == null) {
                filaPersonas[i] = p;
                break;
            }
        }
    }
    public void agregarCabina(Cabina c){
        if (cabinas == null) {
            cabinas = new Cabina[10];
        }
        if (cantidadCabinas < cabinas.length) {
            cabinas[cantidadCabinas] = c;
            cantidadCabinas++;
        }
    }

    public String getColor() {
        return color;
    }

    public int getCantidadCabinas() {
        return cantidadCabinas;
    }

    
    public void esPreferencial(Persona p){
        if (p.getEdad() <= 25 || p.getEdad() >= 60) {
            System.out.println("La persona es preferencial.");
        } else {
            System.out.println("La persona no es preferencial.");
        }
    }
}
