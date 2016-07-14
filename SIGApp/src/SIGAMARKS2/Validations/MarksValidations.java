/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.Validations;

import SIGAMARKS2.Marks.Finders.ApplicationMarks;
import mx.unam.patronato.auditoria.siga.core.model.MarcaDocumento;
import java.util.List;
import mx.unam.patronato.auditoria.siga.core.model.Documento;

/**
 * Clase con métodos de validación de marcas para selección dentro de la base de
 * datos
 *
 * @author J3SU5 Herrera Ledón
 */
public class MarksValidations {

    private static final int ratio = 20;//radio en el que se busca una marca

    /**
     * Busca dentro de una lista de marcas algúna que coinida don la busqueda,
     *
     * @param idDocummento id del documento abierto
     * @param numPage numero de página en edicion
     * @param xSelect} posicion X seleccionada por el mause en pantalla
     * @param ySelect posicion Y seleccionada por el mause en pantalla
     * @return null si no se encuentra coincidencia o la marca documento que
     * coincide y la borra de la base de datos
     */
    public static MarcaDocumento searchCoincidence(Documento idDocummento, int numPage, int xSelect, int ySelect) {
        List<MarcaDocumento> lsmd = ApplicationMarks.getListOfMarksForDocumentPage(idDocummento, numPage);
        return searchCoincidence(lsmd, numPage, xSelect, ySelect);
    }

    public static MarcaDocumento searchCoincidence(List<MarcaDocumento> lsmd, int numPage, int xSelect, int ySelect) {
        System.out.println("searchCoincidence iniciado..." + lsmd.size());
        for (MarcaDocumento marcaDocumento : lsmd) {
            int posMx = marcaDocumento.getPosicionX().intValue();//posicion de la marca actual en x 
            //System.out.println("pos markx:" + posMx + " posClick:" + xSelect);
            int posMy = marcaDocumento.getPosicionY().intValue();//Posicion de la marca actual en y
            //System.out.println("pos markY:" + posMy + " posClicky" + ySelect);
            if ((posMx + ratio) >= xSelect && (posMx - ratio) <= xSelect) { //Verifica que se encuentre dentro de los parametros de x
                if ((posMy + ratio) >= ySelect && (posMy - ratio) <= ySelect) {//Verifica que la marca se encuentre dentro de los parametros de y
                    //Marca_DocumentoDAOImpl.getInstance().delete(marcaDocumento.getIdMarcaDocumento().intValue());//Borra la marca de la base de datos
                    //saca la marca de la lista
                    lsmd.remove(marcaDocumento);
                    System.out.println("MARCA ENCONTRADA");
                    return marcaDocumento;
                }
            }
        }
        System.out.println("Ninguna coincidencia");
        return null;
    }
    
    public static void addMarkToList(List <MarcaDocumento> mdl,MarcaDocumento md){
        mdl.add(md);
    }
    /**
     * Identifica las marcas especiales por su id 1 - VS 6 - Fuente de Datos de
     * Información 10- Observacion 19-Notas Aclaratorias
     *
     * @param idMarca id de la marca que se necesita costatar como especial
     * @return
     */
    public static boolean isSpecialMark(short idMarca) {
        if (idMarca == 1 || idMarca == 6 || idMarca == 10 || idMarca == 19) {
            return true;
        }
        return false;
    }
}
