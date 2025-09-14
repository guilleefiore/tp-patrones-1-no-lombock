package com.biblioteca.prototype;

import com.biblioteca.factorymethod.Libro;
import com.biblioteca.builder.Usuario;

import java.time.LocalDate;

public class Prestamo implements Cloneable {
    private Libro libro;           // referencia compartida en shallow
    private Usuario usuario;       // referencia compartida en shallow (además es inmutable)
    private LocalDate fechaInicio; // inmutable
    private LocalDate fechaFin;    // inmutable

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    // Shallow clone: copia campo a campo; referencias quedan compartidas
    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("No debería fallar", e);
        }
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + (libro != null ? libro.getTitulo() + " [" + libro.getFormato() + "]" : "null") +
                ", usuario=" + (usuario != null ? usuario.getNombre() + " (" + usuario.getDni() + ")" : "null") +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
