
package excepciones;

/**
 * Excepción personalizada que sirve para controlar si la decisión introducida 
 * por el/la usuario/a es válida.
 * 
 * @author Adrián Arjona
 * @version 1.0 Enero 2022
 */
public class ExcepcionDecisionUsuario extends Exception {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    /**
     * Excepción relacionada con la clase Utilidades. Servirá para indicar 
     * la validez del mensaje introducido por el/la usuario/a.
     * 
     * @param msg tipo String. Mensaje de la excepción.
     */
    public ExcepcionDecisionUsuario(String msg){
        
        super(msg) ;
    }
}