/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOUser;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Named
@SessionScoped
public class ClientController implements Serializable{
    /**
     * Varialbe para llamar a la clase User del ejb
     */
    private DTOUser user;
    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
    }
    /**
     * Clase para validar el ingreso de session
     */
    public void validarSesion() {
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            DTOUser usuario = (DTOUser) faces.getExternalContext().getSessionMap().get("user");
            if (usuario == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Inicio de session incorrecto.");
                faces.addMessage(null, msg);
                faces.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("/projectlogin-web/faces/index.xhtml");
            }
            else if(!usuario.getRol().equals("client")){
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Permisos nulos.");
                faces.addMessage(null, msg);
                context.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect(usuario.getRol().toLowerCase()+"/inicio.xhtml");
            }
            user = usuario;
        } catch (Exception e) {

        }
    }
    /**
     * Clase para cerrar session
     *
     * @return
     */
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("session cerrada");
        return "/index.xhtml?faces-redirect=true";
    }
    /**
     * Get del metodo user
     *
     * @return
     */
    public DTOUser getUser() {
        return user;
    }
    /**
     * Set del metodo User
     *
     * @param user
     */
    public void setUser(DTOUser user) {
        this.user = user;
    }
    
}
