package com.biblioteca.builder;

import java.time.LocalDate;
import java.util.Objects;

public final class Usuario {
    // Requeridos
    private final String dni;
    private final String nombre;

    // Opcionales
    private final String email;
    private final String telefono;
    private final LocalDate fechaAlta;
    private final boolean activo;

    private Usuario(Builder b) {
        this.dni = b.dni;
        this.nombre = b.nombre;
        this.email = b.email;
        this.telefono = b.telefono;
        this.fechaAlta = b.fechaAlta;
        this.activo = b.activo;
    }

    // Getters (sin Lombok)
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public LocalDate getFechaAlta() { return fechaAlta; }
    public boolean isActivo() { return activo; }

    // equals/hashCode para tratar al usuario por DNI
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(dni, usuario.dni);
    }
    @Override public int hashCode() { return Objects.hash(dni); }

    @Override public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", activo=" + activo +
                '}';
    }

    // -------- Builder --------
    public static class Builder {
        // Requeridos
        private final String dni;
        private final String nombre;
        // Opcionales
        private String email;
        private String telefono;
        private LocalDate fechaAlta = LocalDate.now();
        private boolean activo = true;

        public Builder(String dni, String nombre) {
            this.dni = dni;
            this.nombre = nombre;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder fechaAlta(LocalDate fechaAlta) {
            this.fechaAlta = fechaAlta;
            return this;
        }

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }

        // Validaciones básicas antes de construir
        private void validar() {
            if (dni == null || dni.isBlank()) {
                throw new IllegalArgumentException("DNI es obligatorio");
            }
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("Nombre es obligatorio");
            }
            if (email != null && !email.contains("@")) {
                throw new IllegalArgumentException("Email inválido");
            }
        }

        public Usuario build() {
            validar();
            return new Usuario(this);
        }
    }
}
