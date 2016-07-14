/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Validations;

import mx.unam.patronato.auditoria.siga.core.model.Usuario;
import mx.unam.patronato.auditoria.siga.core.service.UsuarioService;
import mx.unam.patronato.auditoria.siga.core.service.impl.UsuarioServiceImpl;
import java.util.List;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class USRvalidator {
    private Usuario usuario;

    public USRvalidator() {
    
    }
    
    public boolean isAValidUser(String loggin, char[] pass){
        boolean valid = false;
        try{
        UsuarioService usimpl =  UsuarioServiceImpl.getInstance();
        String pasS = passArrayToString(pass);
        List <Usuario> userList = usimpl.select(loggin, pasS);
        if(userList.size() == 1 ){
            usuario =  userList.get(0);
            return true;
        }    
        }catch(ExceptionInInitializerError eie){
            System.out.println("Error de consulta de usuarios...");
            System.out.println(eie.toString());
        }
        return valid;
    
      }
    
    public  static String passArrayToString(char []pass){
        StringBuilder sBuilder = new StringBuilder();
        for (char c : pass) {
            sBuilder.append(c);
        }
        return sBuilder.toString();
    }
    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
}
