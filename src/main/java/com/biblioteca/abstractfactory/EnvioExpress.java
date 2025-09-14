package com.biblioteca.abstractfactory;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public String enviar(String destinatario) {
        return "Envío EXPRESS a " + destinatario + " (24 hs)";
    }
}
