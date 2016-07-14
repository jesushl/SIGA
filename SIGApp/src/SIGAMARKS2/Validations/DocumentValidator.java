/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Validations;

import mx.unam.patronato.auditoria.siga.core.model.Documento;
import mx.unam.patronato.auditoria.siga.core.model.Usuario;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class DocumentValidator {
    public static  boolean isEditable(Documento doc, Usuario usr){
        if(doc.getIdTrabajoUsuario().getIdUsuario() == usr){
            return true;
        }
        return false;
    }
}
