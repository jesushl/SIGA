/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.Experience;

import mx.unam.patronato.auditoria.siga.core.model.Documento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class UserExperience implements Serializable{

    private Documento[] documentsArray = new Documento[10];
    
    //prueba pasada satisfactoriamente
    public static void main(String[] args) {
        Documento nndoc= new Documento(10l);
        Documento[] nnarr = {nndoc,nndoc,nndoc,nndoc,nndoc,nndoc,nndoc,nndoc,nndoc};
        Documento nNdoc = new Documento(20l);
        UserExperience usre = new UserExperience();
        usre.setDocumentsArray(nnarr);
        usre.addDocument(nNdoc);
        usre.addDocument(nNdoc);
        for (Documento documento : usre.getDocumentsArray()) {
            System.out.println(documento.getIdDocumento());
        }
    }
    
    public List <String > getNameOfFiles(){
        List <String> lNames = new ArrayList();
        for (Documento documento : documentsArray) {
            try{ 
            if(documento.getNombreDocumento() != null)
                lNames.add(documento.getNombreDocumento());
            }catch(NullPointerException npe){
                npe.printStackTrace();
            }
        }
        return lNames;
    }
    

    //Agrega un Documento al arreglo
    public void addDocument(Documento doc) {
            documentsArray = goOverArray(documentsArray);
            documentsArray[0] = doc;
    }

    public Documento[] goOverArray(Documento[] doc) {
        Documento[] nDoc = new Documento[doc.length];
        for (int i = 0; i < doc.length; i++) {
            if (i < doc.length-1)
                nDoc[i+1] = doc[i];
        }
        return nDoc;
    }

    public Documento[] getDocumentsArray() {
        return documentsArray;
    }

    public void setDocumentsArray(Documento[] documentsArray) {
        this.documentsArray = documentsArray;
    }

}
