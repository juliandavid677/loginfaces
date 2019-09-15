/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.User;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface SessionLoginLocal {
    public void agregarUsuarios();
    public User obtenerUsuario(String username, String pass);
}
