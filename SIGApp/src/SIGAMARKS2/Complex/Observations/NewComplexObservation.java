/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Complex.Observations;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mx.unam.patronato.auditoria.siga.core.daoimpl.NormaDAOImpl;
import mx.unam.patronato.auditoria.siga.core.daoimpl.NormatividadDAOImpl;
import mx.unam.patronato.auditoria.siga.core.daoimpl.ObservacionDAOImpl;
import mx.unam.patronato.auditoria.siga.core.daoimpl.ObservacionHistorialDAOImpl;
import mx.unam.patronato.auditoria.siga.core.model.Documento;
import mx.unam.patronato.auditoria.siga.core.model.MarcaDocumento;
import mx.unam.patronato.auditoria.siga.core.model.Norma;
import mx.unam.patronato.auditoria.siga.core.model.Observacion;
import mx.unam.patronato.auditoria.siga.core.model.ObservacionHistorial;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class NewComplexObservation {
    
    /**
     * Agrega una normatividad especial con seccíon norma 0 y normativiad 1
     * 
     * @param descripcionNormaString 
     * cadena que describe la normatividad
     * @return
     * objeto normatividad 
     */
    public static Norma makeSpecialNorma(String descripcionNormaString){
        Norma norma =  new Norma();
        norma.setDescripcionNorma(descripcionNormaString);
        norma.setSeccionNorma("0");
        norma.setIdNormatividad(NormatividadDAOImpl.getInstance().select(1));
        return norma;
    }
    public static Observacion addSpecialObservation(String concepto, String descripcion){
        Observacion observacion = new Observacion();
        observacion.setConceptoObs(concepto);
        observacion.setDescripcionObs(descripcion);
        ObservacionDAOImpl.getInstance().incert(observacion);//Crea la Observacion
        List <Observacion>  lobs =  ObservacionDAOImpl.getInstance().select(concepto, descripcion);//Busca la observacion creada
          if(lobs.size() > 0){  
            return observacion = lobs.get(0);  
          }else{
              return null;
          }  
    }
    /**
     * Método que agrega a la base de datos una norma nueva de auditor bajo el concepto
     * de normatividad con id 1 creada por auditor en sistema SIGA
     * @param descripcionNorma
     * descripcion de la norma que se agrega por el auditor 
     * @return
     * Norma que se acaba de agregar con su ID
     */
    public static Norma addSpecialNorma(String descripcionNorma){
         Norma norma = makeSpecialNorma(descripcionNorma);
         NormaDAOImpl.getInstance().insert(norma);
         List<Norma> normaL =NormaDAOImpl.getInstance().select(NormatividadDAOImpl.getInstance().select(1), descripcionNorma);
         if(normaL.size() > 0){
             return normaL.get(0);
         }
         return null;
    }
    public static ObservacionHistorial addSpecialObservacionHistorial(Documento documento,MarcaDocumento marcaDocumento, String concepto, String descripcion,String causa, String efecto,String descripcionNormatividad){
        
        
        ObservacionHistorial objoh = new ObservacionHistorial();//Crea una observacion historial
        List <Norma> objnorma = NormaDAOImpl.getInstance().select(NormatividadDAOImpl.getInstance().select(1), descripcion);
        if(objnorma.size() > 0){
            objoh.setIdNorma(objnorma.get(0));//Agrega la Norma
        }
        objoh.setIdObservacion(addSpecialObservation(concepto, descripcion));//Agrega la Observacion
        objoh.setIdDocumento(documento);
        objoh.setCausaObs(causa);
        objoh.setEfectoRiesgoObs(efecto); 
        objoh.setOrigen(1);//Se  marca como el origen de la observacion
        objoh.setEstatusObservacion("No atendida");
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(documento.getIdTrabajoUsuario().getIdTrabajo().getFechaRealInicioEjecucion());
        objoh.setAnioObservacion((short)calendarDate.get(Calendar.YEAR));//Obtiene el año de la fecha... método deprecado
        objoh.setVigente((short)1);
        objoh.setNumPagina(marcaDocumento.getNumPagina());
        objoh.setPosicionX(marcaDocumento.getPosicionX());
        objoh.setPosicionY(marcaDocumento.getPosicionY());
        objoh.setIdRubro(documento.getIdRubro());
        objoh.setIdTrabajoUsuario(documento.getIdTrabajoUsuario());
        objoh.setIdNorma(addSpecialNorma(descripcion));
        ObservacionHistorialDAOImpl.getInstance().insert(objoh);
        List<ObservacionHistorial> obsh;
        obsh = ObservacionHistorialDAOImpl.getInstance().selectTDO(documento.getIdTrabajoUsuario(), documento, 1);
        if(obsh.size() > 0){
            System.out.println("Tamaño "+obsh.size());
            
            return obsh.get(1);
        }else{
            System.out.println("Error de busqueda ");
        }
        return null;
    }  
    
    
}
