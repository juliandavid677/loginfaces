/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOUser;
import com.mycompany.interfaces.ISessionLogin;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Stateful
public class SessionLogin implements ISessionLogin {
    /**
     * Variable privada encapsulada para un usuario
     */
    private DTOUser usuario1;
    /**
     * Variable privada encapsulada para un usuario
     */
    private DTOUser usuario2;
    /**
     * Creacion de la lista
     */
    private List<DTOUser> listaUsuarios;
    /**
     * Inicializacion de la lista
     */
    public SessionLogin() {
        listaUsuarios = new ArrayList();
    }
    /**
     * Metodo para agregar usuarios
     */
    @Override
    public void agregarUsuarios() {
        //usuario1 = new DTOUser("David", "admin", "david", "12345678");
        //usuario2 = new DTOUser("German", "client", "german", "87654321");

        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        System.out.println("Usuario Agregados");
        System.out.println(listaUsuarios);
        
    }
    /**
     * Metodo para obtener los usuarios bajo la comparacion de datos
     */
    @Override
    public DTOUser obtenerUsuario(String username, String pass){
        System.out.println(listaUsuarios);
        for (DTOUser usuario : listaUsuarios) {
            if(usuario.getUsername().equals(username) && usuario.getPass().equals(pass)){
                return usuario;
            }
        }
        return null;
    }
}
