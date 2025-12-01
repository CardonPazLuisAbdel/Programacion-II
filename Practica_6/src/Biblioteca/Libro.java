package Biblioteca;

import java.util.List;

public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private List<Pagina> paginas;
    
    public Libro() {}
    
    public Libro(String titulo, String isbn, Autor autor, List<Pagina> paginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.paginas = paginas;
    }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    
    public List<Pagina> getPaginas() { return paginas; }
    public void setPaginas(List<Pagina> paginas) { this.paginas = paginas; }
    
    public int getNumeroPaginas() {
        return paginas != null ? paginas.size() : 0;
    }
    
    @Override
    public String toString() {
        return "Libro: " + titulo + 
               "\nISBN: " + isbn + 
               "\nAutor: " + autor.toString() + 
               "\nPáginas: " + getNumeroPaginas();
    }
}