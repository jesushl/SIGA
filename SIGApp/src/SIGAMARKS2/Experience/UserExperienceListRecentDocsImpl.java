/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.Experience;

import mx.unam.patronato.auditoria.siga.core.dao.DocumentoDAO;
import mx.unam.patronato.auditoria.siga.core.daoimpl.DocumentoDAOImpl;
import mx.unam.patronato.auditoria.siga.core.model.Documento;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author J3SU5 Herrera Ledón
 */
public  class UserExperienceListRecentDocsImpl {
    
    
    public UserExperienceListRecentDocsImpl() {
        
    }
    
    public static void main(String[] args) {
        String usuario = "jesus";
        UserExperience uJExperience = new UserExperience();
        Documento doc1 = null;
        Documento doc2 = null;
        Documento doc3 = null;
        DocumentoDAO docDAO = DocumentoDAOImpl.getInstance();
        doc1 = docDAO.select(1);
        doc2 = docDAO.select(2);
        doc3 = docDAO.select(3);
        uJExperience.addDocument(doc1);
        uJExperience.addDocument(doc1);
        uJExperience.addDocument(doc1);
        uJExperience.addDocument(doc1);
        uJExperience.addDocument(null);
        uJExperience.addDocument(doc2);
        uJExperience.addDocument(doc2);
        uJExperience.addDocument(doc3);
        uJExperience.addDocument(doc3);
        uJExperience.addDocument(doc3);
        UserExperienceListRecentDocsImpl.writeFileUserExperienceObj(uJExperience, usuario);
        UserExperience ue2 = UserExperienceListRecentDocsImpl.readFileUserExpirenceObj(usuario);
        Documento[] doc = ue2.getDocumentsArray();
        for (Documento documento : doc) {
            if(documento ==  null) continue;
            System.out.println(documento.getNombreDocumento());
        }
    }
    
    /**
     * Lee un archivo objeto en dirección c:\\SIGA\\"+Userloggin+".siga
     *  regresa un objeto UserExperience
     * 
     * @param usrLoggin
     * nombre de loggin con el que se ha loegueado un usuario
     * @return
     * UserExperience
     */
    public static UserExperience readFileUserExpirenceObj(String usrLoggin){
        FileInputStream fin =  null;
        ObjectInputStream ois=  null;
        UserExperience usrExpObj = null;
        try {
            fin = new FileInputStream("c:\\SIGA\\META\\"+usrLoggin+".siga");
            ois = new ObjectInputStream(fin);
            try {
                usrExpObj =(UserExperience)  ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
                ois.close();
                return null;
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (IOException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fin.close();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("UserExperienceListRecentDocsImpl ..... "
                        + "FileInputStream y ObjectInputStream no se han serrado");
            }
        }
        return usrExpObj;
    }
    
    /**
     * Guarda un Archivo objeto UserExperience
     * @param usrExpObj
     * Objeto a guardar en archivo
     * @param usrLoggin
     * nombre de usuario loggin 
     * @return 
     * true si se logra la escritura y false se falla 
     */
    public static boolean writeFileUserExperienceObj(UserExperience usrExpObj,String usrLoggin){
        
            FileOutputStream fout = null;
            ObjectOutputStream oos = null;
        try {    
            fout = new FileOutputStream("c:\\SIGA\\META\\"+usrLoggin+".siga");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(usrExpObj);
            fout.close();
            oos.close();
            return true;        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
    private byte[] encrypt(UserExperience ue){
        String encryptionKey = "s1g4pr0toc01l001";
        String IV = "SIGAAPPSIGAAPPSI"
        try {
            Cipher c = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
            SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
            c.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(IV.getBytes("UTF-8")));
            return c.doFinal(ue.);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no existe el algoritmo");
        } catch (NoSuchPaddingException ex) {
            System.out.println("error de relleno");
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserExperienceListRecentDocsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
}
