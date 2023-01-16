
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
    
    public ExcepcionDecisionUsuario(String msg){
        
        super(msg) ;
    }
}