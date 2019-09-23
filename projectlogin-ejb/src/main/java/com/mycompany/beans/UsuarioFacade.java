/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOUser;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.IUsuarioFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {

    @PersistenceContext(unitName = "login_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    /**
     * Metodo login para comparar los datos
     * @param username
     * @param password
     * @return 
     */
    @Override
    public DTOUser login(String username, String password) {
        DTOUser user = null;
        Usuario u = null;
        try {
            System.out.println("entro aqui");

            Query consultaLogin = em.createQuery("FROM Usuario u WHERE u.user_name=?1 AND u.pass=?2");
            consultaLogin.setParameter(1, username);
            consultaLogin.setParameter(2, password);
            List<Usuario> listUsuario = consultaLogin.getResultList();
            if (!listUsuario.isEmpty()) {
                u = listUsuario.get(0);
                user = new DTOUser(u.getId(), u.getNombre(), u.getRol(), u.getUser_name(), u.getPass());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }
}
