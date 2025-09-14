package com.biblioteca.factorymethod;

public class LibroFisico implements Libro {
    private final String titulo;
    private final int paginas;

    public LibroFisico(String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getFormato() { return "Físico (" + paginas + " págs.)"; }

    @Override
    public String toString() {
        return "LibroFisico{titulo='" + titulo + "', paginas=" + paginas + "}";
    }
}
