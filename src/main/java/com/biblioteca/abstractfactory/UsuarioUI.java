package com.biblioteca.abstractfactory;

public class UsuarioUI implements InterfazUI {
    @Override
    public String render() {
        return "UI de Usuario: catálogo, préstamos y perfil";
    }
}
