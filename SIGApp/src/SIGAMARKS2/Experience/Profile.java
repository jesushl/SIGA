/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Experience;

import mx.unam.patronato.auditoria.siga.core.model.Trabajo;
import mx.unam.patronato.auditoria.siga.core.model.Usuario;
import java.util.List;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class Profile {
    private Integer idUsuario;
    private List<Integer> idsTrabajoList;
    private List<Integer> idsRubroList; 

    
    public void getidsTrabajos(){
        if(idUsuario != null || idUsuario != 0){
            
        }
    }
    
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Integer> getIdsTrabajoList() {
        return idsTrabajoList;
    }

    public void setIdsTrabajoList(List<Integer> idsTrabajoList) {
        this.idsTrabajoList = idsTrabajoList;
    }

    public List<Integer> getIdsRubroList() {
        return idsRubroList;
    }

    public void setIdsRubroList(List<Integer> idsRubroList) {
        this.idsRubroList = idsRubroList;
    }
    
}
