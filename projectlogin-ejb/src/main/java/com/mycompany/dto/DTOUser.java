/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 * @author Julián Parra
 * @author Germán García
 */
public class DTOUser implements Serializable {

    /**
     * Variable id user
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Varialbe privada de nombre
     */
    private String nombre;
    /**
     * Varialbe privada de rol
     */
    private String rol;
    /**
     * Varialbe privada de username
     */
    private String user_name;
    /**
     * Varialbe privada de pass
     */
    private String pass;

    /**
     * Varialbe getNombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Varialbe setNombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Varialbe getRol
     *
     * @return
     */
    public String getRol() {
        return rol;
    }

    /**
     * Varialbe setRol
     *
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Varialbe getUsername
     *
     * @return
     */
    public String getUsername() {
        return user_name;
    }

    /**
     * Varialbe setUsername
     *
     * @param username
     */
    public void setUsername(String username) {
        this.user_name = username;
    }

    /**
     * Varialbe getPass
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     * Varialbe setPass
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Metodo Constructor
     *
     * @param id
     * @param nombre
     * @param rol
     * @param user_name
     * @param pass
     */
    public DTOUser(int id, String nombre, String rol, String user_name, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.user_name = user_name;
        this.pass = pass;
    }

}
