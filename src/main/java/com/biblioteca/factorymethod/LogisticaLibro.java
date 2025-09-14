package com.biblioteca.factorymethod;

public abstract class LogisticaLibro {

    // Factory Method
    public abstract Libro crearLibro(TipoLibro tipo, String titulo);

    // Template: un pequeño flujo común de "registro"
    public String registrar(TipoLibro tipo, String titulo) {
        Libro libro = crearLibro(tipo, titulo);
        return "Creado: " + libro.getTitulo() + " → " + libro.getFormato();
    }
}
