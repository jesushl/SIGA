/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.Validations;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class OBSvalidator {

    static String message;
    static String concepto;
    static String description;
    static String causa;
    static String efecto;
    static String normatividad;

    public static boolean make_message() {
        boolean exist_message = false;
        if (concepto.length() == 0) {
            message = message + "Concepto no puede quedar vacío";
        }
        if (description.length() == 0 || description == null) {
            message = message + (char) 10 + "Descripción no puede quedar vacía";
        }
        /*
         if(causa.length()  == 0 ){
         message = message + (char)10 +"Causa no puede quedar vacía";
         }
         if(efecto.length() == 0 ){
         message = message + (char)10 + "El efecto no puede quedar vacío";
         }
         if(normatividad.length() == 0  || normatividad == null){
         message = message + (char)10 +  "La normatividad no puede quedar vacía";
         }
         */
        if (message.length() > 1) {
            exist_message = true;
        }

        return exist_message;
    }

    public static void cleaner() {
        message = "";
        concepto = "";
        description = "";
        causa = "";
        efecto = "";
        normatividad = "";
    }

    public static String getConcepto() {
        return concepto;
    }

    public static void setConcepto(String concepto) {
        OBSvalidator.concepto = concepto;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        OBSvalidator.description = description;
    }

    public static String getCausa() {
        return causa;
    }

    public static void setCausa(String causa) {
        OBSvalidator.causa = causa;
    }

    public static String getEfecto() {
        return efecto;
    }

    public static void setEfecto(String efecto) {
        OBSvalidator.efecto = efecto;
    }

    public static String getNormatividad() {
        return normatividad;
    }

    public static void setNormatividad(String normatividad) {
        OBSvalidator.normatividad = normatividad;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        OBSvalidator.message = message;
    }

}
