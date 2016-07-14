/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.Validations;

/**
 *
 * @author J3SU5 Herrera Ledón
 */
public class ValidCharacters {

    final static byte LLOWER_LETTERS[] = new byte[]{0x61, 0x7a};//Primer caracter al ultimo en minusculas
    final static byte UPER_LETTERS[] = new byte[]{0x41, 0x5a};//Primer y ultimo caracter en mayusculas
    final static char ACENT_LETTERS[] = new char[]{0xe1, 0xc1, 0xe9, 0xc9, 0xed, 0xcd, 0xf3, 0xd3, 0xfa, 0xda, 0xfc, 0xdc, 0xf1, 0xd1};
    final static char SPECIALSYMBOLS[] = new char[]{34, '#', '$', '%', '\'', '(', ')', '*', '+', ',', '.', ':', ';', '=', '?', ' ', 8, 13};

    public static void main(String[] args) {
        System.out.println((int) 'Ŷ');
        System.out.println((char)07);
        String string = "a b c d é ? " + (char)374;
        System.out.println(string);
        ValidCharacters objval = new ValidCharacters();
        System.out.println(objval.validatingString(string));
        for (int i = 0; i < SPECIALSYMBOLS.length; i++) {
            System.out.print(SPECIALSYMBOLS[i] + " ");
        }
        
    }

    public static String validatingString(String originalMessage) {
        char oCharacters[] = originalMessage.toCharArray();
        StringBuilder ns = new StringBuilder();
        for (char c : oCharacters) {
            if(validCharacter(c)){
                ns.append(c);
            }
        }
        originalMessage = ns.toString();
        return originalMessage;
    }
    
    public static boolean validCharacter(char character){
        boolean match =  false;
        for (int i = LLOWER_LETTERS[0] ; i <= LLOWER_LETTERS[1] ; i++) {
            if(character == (char)i ){
                return  true;
            }
        }
        for (int i = UPER_LETTERS[0]; i <= UPER_LETTERS[1]; i++) {
            if(character == (char)i ){
                return  true;
            }
        }
        for (char b : ACENT_LETTERS) {
            if(character == b){
                return  true;
            }
        }
        for (char b : SPECIALSYMBOLS) {
            if(character == b){
                return  true;
            }
        }
        return false;
    }

}
