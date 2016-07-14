/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Marks.Finders;

import java.util.List;
import mx.unam.patronato.auditoria.siga.core.daoimpl.MarcaDAOImpl;
import mx.unam.patronato.auditoria.siga.core.daoimpl.Marca_DocumentoDAOImpl;
import mx.unam.patronato.auditoria.siga.core.model.Documento;
import mx.unam.patronato.auditoria.siga.core.model.MarcaDocumento;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class ApplicationMarks {
    private  List<MarcaDocumento> marksOnDocument;

    public ApplicationMarks() {
    }
    /**
     * 
     * @param idDocumento
     * @param numPag
     * @return 
     */
    public static  List <MarcaDocumento> getListOfMarksForDocumentPage(Documento idDocumento, int numPag){
        ApplicationMarks gpmObj = new  ApplicationMarks();
        gpmObj.setMarksOnDocument(Marca_DocumentoDAOImpl.getInstance().select(idDocumento, numPag));
        return gpmObj.getMarksOnDocument();
    }
     /**
      * regresa el nombre de la marca a travez de idMarca
      * @param idMarca
      * idMarca obtenida en Marca_Documento
      * @return 
      * String de nombre marca 
      */
    public static  String getMarkName(int idMarca){
        return MarcaDAOImpl.getInstance().select(idMarca).getNombreMarca();
    }
    public List<MarcaDocumento> getMarksOnDocument() {
        return marksOnDocument;
    }

    public void setMarksOnDocument(List<MarcaDocumento> marksOnDocument) {
        this.marksOnDocument = marksOnDocument;
    }
    
    
    
}
