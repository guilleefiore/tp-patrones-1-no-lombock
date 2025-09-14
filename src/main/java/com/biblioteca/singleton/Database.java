package com.biblioteca.singleton;

import java.util.ArrayList;
import java.util.List;

public enum Database {
    INSTANCE; // única instancia

    private final List<String> libros = new ArrayList<>();

    public void agregarLibro(String libro) {
        libros.add(libro);
    }

    public List<String> listarLibros() {
        return new ArrayList<>(libros);
    }
}
