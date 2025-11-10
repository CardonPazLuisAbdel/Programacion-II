package practica_5;

import java.util.ArrayList;
import java.util.List;

public class Libro {
        private String titulo;
    private String isbn;
    private List<Pagina> paginas;

    public Libro(String titulo, String isbn, List<String> contenidoPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        int num = 1;
        for (String texto : contenidoPaginas) {
            this.paginas.add(new Pagina(num++, texto));
        }
    }

    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }

    public void leer() {
        System.out.println("\nLeyendo libro: " + titulo + " (ISBN: " + isbn + ")");
        for (Pagina p : paginas) {
            p.mostrarHorario();
        }
    }
}


