package com.biblioteca.abstractfactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public String enviar(String destinatario) {
        return "Envío NORMAL a " + destinatario + " (48-72 hs)";
    }
}
