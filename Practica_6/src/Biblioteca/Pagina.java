package Biblioteca;

public class Pagina {
    private int numero;
    private String contenido;
    
    public Pagina() {}
    
    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    
    @Override
    public String toString() {
        return "Página " + numero + ": " + contenido;
    }
}
