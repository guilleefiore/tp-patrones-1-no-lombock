package com.biblioteca.factorymethod;

public class LibroDigital implements Libro {
    private final String titulo;
    private final String formatoArchivo; // pdf, epub, mobi

    public LibroDigital(String titulo, String formatoArchivo) {
        this.titulo = titulo;
        this.formatoArchivo = formatoArchivo;
    }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getFormato() { return "Digital (" + formatoArchivo + ")"; }

    @Override
    public String toString() {
        return "LibroDigital{titulo='" + titulo + "', formato='" + formatoArchivo + "'}";
    }
}
