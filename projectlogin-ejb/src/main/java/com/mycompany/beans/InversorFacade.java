/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.interfaces.IInversorFacade;
import com.mycompany.entity.Inversor;
import com.mycompany.entity.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Stateless
public class InversorFacade extends AbstractFacade<Inversor> implements IInversorFacade {

    @PersistenceContext(unitName = "login_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InversorFacade() {
        super(Inversor.class);
    }

    /**
     * Metodo para crear inversor y cuenta
     * @param dtoinversor
     * @param dtocuenta
     */
    @Override
    public void crearInversor(DTOInversor dtoinversor, DTOCuenta dtocuenta) {
        Inversor inversor = new Inversor();
        inversor.setNombreInversor(dtoinversor.getNombreInversor());
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(dtocuenta.getNumeroCuenta());
        inversor.setCuenta(cuenta);
        cuenta.setInversor(inversor);
        create(inversor);
    }

}
