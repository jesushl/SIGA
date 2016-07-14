/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.FilesManagement.PDF;

import java.io.File;
import mx.unam.patronato.auditoria.siga.core.model.Documento;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class GetSIGAPDF {

    static String dirSIGA = "C:\\SIGA\\";//      dirSiga + AñoTrabajo

    public GetSIGAPDF() {
    }

    public static String getPDFDirFromSIGA(Documento documento) {
        
        String anoTrabajo   = documento.getIdTrabajoUsuario().getIdTrabajo().getAnioPrograma().toString();//año
        String claveTrabajo = documento.getIdTrabajoUsuario().getIdTrabajo().getClaveTrabajo();//Clave trabajo
        
        String refDocu = documento.getReferenciaDocumento();//Referencia documento
        String nombreDoc = documento.getNombreDocumento();//Nombre del documento
        String completeDir = dirSIGA + anoTrabajo+ "\\" + claveTrabajo + refDocu + nombreDoc;//
        System.out.println(completeDir);
        return completeDir;
    }
    
    public static File getFileFromSIGA(Documento documento){
        File document;
        document = new File(getPDFDirFromSIGA(documento));
        return document;
    }
    
    public static String getDirSIGA() {
        return dirSIGA;
    }

    public static void setDirSIGA(String dirSIGA) {
        GetSIGAPDF.dirSIGA = dirSIGA;
    }
    
}
