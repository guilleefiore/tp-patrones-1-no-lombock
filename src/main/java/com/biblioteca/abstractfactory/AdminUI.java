package com.biblioteca.abstractfactory;

public class AdminUI implements InterfazUI {
    @Override
    public String render() {
        return "UI de Administrador: panel con métricas y gestión avanzada";
    }
}
