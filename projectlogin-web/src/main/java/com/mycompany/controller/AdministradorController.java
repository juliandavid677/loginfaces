/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.dto.DTOUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.mycompany.interfaces.IInversorFacade;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Named
@SessionScoped
public class AdministradorController implements Serializable {
    
    @EJB
    IInversorFacade inversorCon;
    
    /**
     * Varialbe para llamar a la clase User del ejb
     */
    private DTOUser user;

    /**
     * Creates a new instance of AdministradorController
     */
    public AdministradorController() {
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
                        "Está tratando de ingresar de forma erronea al sitio.");
                faces.addMessage(null, msg);
                faces.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("/projectlogin-web/faces/error.xhtml");
            } else if (!usuario.getRol().equals("admin")) {
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No tiene permisos para ingresar a esta sección del sitio.");
                faces.addMessage(null, msg);
                context.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect(usuario.getRol().toLowerCase() + "/inicio.xhtml");
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
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("session cerrada");
        return "/index.xhtml?faces-redirect=true";
    }
    /**
     * Varialbe nombre inversor
     */
    private String nombreInversor;
    /**
     * Varialbe para cuenta
     */
    private String cuenta;
    /**
     * Get variable cuenta
     *
     * @return
     */
    public String getNombreInversor() {
        return nombreInversor;
    }
    /**
     * Set variable 
     *
     * @param nombreInversor
     */
    public void setNombreInversor(String nombreInversor) {
        this.nombreInversor = nombreInversor;
    }
    /**
     * Get variable cuenta
     *
     * @return
     */
    public String getCuenta() {
        return cuenta;
    }
    /**
     * Set variable 
     *
     * @param cuenta
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Metodo para agregar los inversores y las cuentas
     *
     */
    public void agregarInversor(){
        DTOInversor dtoinversor = new DTOInversor();
        DTOCuenta dtocuenta = new DTOCuenta();
        dtoinversor.setNombreInversor(nombreInversor);
        dtocuenta.setNumeroCuenta(cuenta);
        inversorCon.crearInversor(dtoinversor, dtocuenta);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", 
            "Inversor " + nombreInversor + "Agregado con Exito!"));
        
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
