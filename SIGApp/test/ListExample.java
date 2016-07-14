
import java.util.ArrayList;
import java.util.List;
import mx.unam.patronato.auditoria.siga.core.model.MarcaDocumento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class ListExample {
    
    public static void main(String[] args) {
        List <MarcaDocumento> lmed = new ArrayList();
        MarcaDocumento md1 = new MarcaDocumento(1L);
        MarcaDocumento md2 = new MarcaDocumento(2L);
        MarcaDocumento md3 = new MarcaDocumento(3L);
        lmed.add(md1);
        lmed.add(md2);
        lmed.add(md3);
        ListEditor.auita3(lmed);
        for (MarcaDocumento marcaDocumento : lmed) {
            System.out.println(marcaDocumento.getIdDocumento());
        }
    }
    
}
