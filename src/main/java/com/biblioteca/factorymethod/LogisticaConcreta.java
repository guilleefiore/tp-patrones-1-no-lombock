package com.biblioteca.factorymethod;

public class LogisticaConcreta extends LogisticaLibro {

    @Override
    public Libro crearLibro(TipoLibro tipo, String titulo) {
        switch (tipo) {
            case FISICO:
                // valor por defecto de páginas solo para el ejemplo
                return new LibroFisico(titulo, 350);
            case DIGITAL:
                // valor por defecto de formato
                return new LibroDigital(titulo, "pdf");
            default:
                throw new IllegalArgumentException("Tipo de libro no soportado: " + tipo);
        }
    }
}
