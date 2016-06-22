package com.example.sarapavas.inicioproyfinal;

/**
 * Created by Sara Pavas on 19/06/2016.
 */
public class Usuario {

    private String nombre,email,pass;
    public Usuario(){}
    public Usuario(String nombre, String email, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }
}
