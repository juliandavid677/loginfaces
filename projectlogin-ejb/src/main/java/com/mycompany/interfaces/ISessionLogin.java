/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOUser;
import javax.ejb.Local;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Local
public interface ISessionLogin {
    /**
     * Llamado del metodo agregar usuarrios
     */
    public void agregarUsuarios();
    /**
     * Paso de datos del metodo obtenerUsuario
     * @param username
     * @param pass
     * @return 
     */
    public DTOUser obtenerUsuario(String username, String pass);
}
