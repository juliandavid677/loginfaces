/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

 
import com.mycompany.dto.User;
import com.mycompany.interfaces.SessionLoginLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author DaveHell
 */
@Named
@RequestScoped
public class IndexController implements Serializable{
    
    private List<User> listaUsuarios;
    private String username;
    private String pass;
    
    @EJB
    SessionLoginLocal ejb;
    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
        listaUsuarios = new ArrayList();
    }

   public String iniciarSesion(){
        User user;
        ejb.agregarUsuarios();
        user = ejb.obtenerUsuario(username, pass);
        if(user!=null){
            System.out.println("ruta" + " " +user.getRol().toLowerCase());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);            
            return user.getRol()+"/inicio.xhtml?faces-redirect=true";
        }else{
            return "index.xhtml?faces-redirect=true";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   

    
    
    
    
}
