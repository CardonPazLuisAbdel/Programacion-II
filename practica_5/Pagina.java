package practica_5;

public class Pagina {
    private int numero;
    private String contenido;

    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    public void mostrarHorario() {
        System.out.println("Pagina " + numero + ": " + contenido);
    }
}
