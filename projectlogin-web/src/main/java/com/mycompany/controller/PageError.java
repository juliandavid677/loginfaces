/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 * @author Julián Parra 
 * @author Germán García
 */
@Named
@SessionScoped
public class PageError implements Serializable{

    /**
     * Creates a new instance of PageError
     */
    public PageError() {
    }
    /**
     * Varialbe privada message
     */
    private String message;
    /**
     * Varialbe get  message
     * @return 
     */
    public String getMessage() {
        return message;
    }
    /**
     * Varialbe set  message
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Metodo de Navegacion
     */
    public String navigate() {
        System.out.println(10 / 0);
        return "index";
    }
}
