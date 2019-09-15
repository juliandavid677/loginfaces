/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.User;
import com.mycompany.interfaces.SessionLoginLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author DaveHell
 */
@Stateful
public class SessionLogin implements SessionLoginLocal {

    private User usuario1;
    private User usuario2;
    private List<User> listaUsuarios;

    public SessionLogin() {
        listaUsuarios = new ArrayList();
    }

    @Override
    public void agregarUsuarios() {
        usuario1 = new User("David", "admin", "david", "12345678");
        usuario2 = new User("German", "client", "german", "87654321");

        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        System.out.println("Usuario Agregados");
        System.out.println(listaUsuarios);
        
    }
    @Override
    public User obtenerUsuario(String username, String pass){
        System.out.println(listaUsuarios);
        for (User usuario : listaUsuarios) {
            if(usuario.getUsername().equals(username) && usuario.getPass().equals(pass)){
                return usuario;
            }
        }
        return null;
    }
}
