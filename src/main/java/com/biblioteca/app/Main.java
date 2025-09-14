package com.biblioteca.app;

import com.biblioteca.prototype.Prestamo;
import com.biblioteca.abstractfactory.*;
import com.biblioteca.builder.Usuario;
import com.biblioteca.factorymethod.*; // Libro, LibroDigital, LibroFisico, etc.
import com.biblioteca.singleton.Database;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n===== PRUEBA DEL PATRÓN SINGLETON ===== \n");

        Database db1 = Database.INSTANCE;
        Database db2 = Database.INSTANCE;

        db1.agregarLibro("El Señor de los Anillos");
        db1.agregarLibro("Cien Años de Soledad");

        System.out.println("Libros en DB1: " + db1.listarLibros());
        System.out.println("Libros en DB2: " + db2.listarLibros());

        System.out.println("¿DB1 y DB2 son la misma instancia? " + (db1 == db2));

        System.out.println("\n===== PRUEBA DEL PATRÓN FACTORY METHOD ===== \n");

        LogisticaLibro logistica = new LogisticaConcreta();

        System.out.println(logistica.registrar(TipoLibro.FISICO, "Clean Code"));
        System.out.println(logistica.registrar(TipoLibro.DIGITAL, "Design Patterns"));

        Libro f1 = logistica.crearLibro(TipoLibro.FISICO, "El Quijote");
        Libro d1 = logistica.crearLibro(TipoLibro.DIGITAL, "Refactoring");

        System.out.println(f1);
        System.out.println(d1);

        System.out.println("\n===== PRUEBA DEL PATRÓN ABSTRACT FACTORY ===== \n");

        Aplicacion appAdmin = new Aplicacion(new AdminFactory());
        appAdmin.mostrarUI();
        appAdmin.hacerEnvio("Guillermina");

        Aplicacion appUsuario = new Aplicacion(new UsuarioFactory());
        appUsuario.mostrarUI();
        appUsuario.hacerEnvio("Cliente Juan");

        System.out.println("\n===== PRUEBA DEL PATRÓN BUILDER ===== \n");

        Usuario u1 = new Usuario.Builder("42123456", "Guillermina")
                .email("guille@example.com")
                .telefono("+54 9 261 555-1111")
                .build();

        Usuario u2 = new Usuario.Builder("40999888", "Juan Perez")
                .activo(false)
                .fechaAlta(LocalDate.of(2024, 10, 1))
                .build();

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("\n===== PRUEBA DEL PATRÓN PROTOTYPE ===== \n");

        // Reutilizamos tipos ya creados
        Usuario usu = new Usuario.Builder("42123456", "Guillermina")
                .email("guille@example.com")
                .build();

        Libro libroOriginal = new LibroDigital("Design Patterns", "pdf");

        Prestamo p1 = new Prestamo(
                libroOriginal,
                usu,
                LocalDate.of(2025, 9, 14),
                LocalDate.of(2025, 9, 28)
        );

        // Clones superficiales
        Prestamo p2 = p1.clone();
        Prestamo p3 = p1.clone();

        // Cambiamos algunos datos del clon (sin tocar p1)
        p2.setFechaFin(LocalDate.of(2025, 10, 5));
        p2.setLibro(new LibroFisico("Design Patterns (Ed. Impresa)", 450));

        // p3 queda idéntico al original, pero es otra instancia Prestamo
        System.out.println("Original p1: " + p1);
        System.out.println("Clon p2:     " + p2);
        System.out.println("Clon p3:     " + p3);

        // Evidencias de shallow:
        // 1) El usuario es la MISMA referencia en p1 y p3 (shallow copy)
        System.out.println("¿usuario compartido p1/p3? " + (p1.getUsuario() == p3.getUsuario()));
        // 2) Si no reemplazamos el libro, el clon compartiría la misma referencia de libro.
        // En p2 lo reemplazamos, por eso ahora difiere:
        System.out.println("¿libro compartido p1/p3?   " + (p1.getLibro() == p3.getLibro()));
        System.out.println("¿p1 y p2 son el mismo objeto Prestamo? " + (p1 == p2));
    }
}
