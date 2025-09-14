package com.biblioteca.abstractfactory;

public class Aplicacion {
    private final InterfazUI ui;
    private final MetodoEnvio envio;

    public Aplicacion(AbstractFactory factory) {
        this.ui = factory.crearUI();
        this.envio = factory.crearEnvio();
    }

    public void mostrarUI() {
        System.out.println(ui.render());
    }

    public void hacerEnvio(String destinatario) {
        System.out.println(envio.enviar(destinatario));
    }
}
