/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.nio.MappedByteBuffer;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Entity
@Table(name = "inversor")
public class Inversor implements Serializable{
    /**
     * Variable id autoincrementable tabla cuenta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    /**
     * Variable nombre inversor
     */
    @Column (name = "nombre_inversor")
    private String nombreInversor;
    /**
     * Variable de asociacion foranea de las tablas
     */
    @OneToOne(mappedBy = "inversor", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Cuenta cuenta;
    
    public Inversor(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreInversor() {
        return nombreInversor;
    }

    public void setNombreInversor(String nombreInversor) {
        this.nombreInversor = nombreInversor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}
