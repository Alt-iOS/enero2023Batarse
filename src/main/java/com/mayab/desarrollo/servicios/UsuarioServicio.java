package com.mayab.desarrollo.servicios;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistence.UserDAO;

public class UsuarioServicio {

    private UserDAO dao;
    public UsuarioServicio(UserDAO d){
        this.dao =d;
    }
    public boolean login(String user, String pass){
        boolean result = false;
        Usuario usuario =dao.findByName(user);
        if(usuario != null){
            if ( usuario.getPassword().equals(pass)){
                result = true;
            }
        }
        return result;
    }
}