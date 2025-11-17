package SEGUNDO_PARCIAL.PREGUNTA_2;

public class Main {
    public static void main(String[] args) {
        MiTeleferico teleferico = new MiTeleferico();

        Linea lineaRojo = new Linea("Rojo");
        Linea lineaAmarillo = new Linea("Amarillo");
        Linea lineaVerde = new Linea("Verde");

        teleferico.agregarCabina("Rojo");
        teleferico.agregarCabina("Amarillo");
        teleferico.agregarCabina("Verde");
        
        Persona persona1 = new Persona("Juan", 65, 70);
        Persona persona2 = new Persona("Ana", 22, 60);
        Persona persona3 = new Persona("Carlos", 65, 80);

        teleferico.agregarPersonaFila(persona1, "Rojo");
        teleferico.agregarPersonaFila(persona2, "Amarillo");
        teleferico.agregarPersonaFila(persona3, "Verde");

        System.out.println("Verificando ingresos de tarifa regular:");
        teleferico.ingresosNoPreferencial(persona1, "Rojo");

    }
}
