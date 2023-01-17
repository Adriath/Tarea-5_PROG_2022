
package excepcionespersonaje;

/**
 * Clase de contiene la/s excepción/es para la creación de los personajes.
 * 
 * @author Adrián Arjona
 */
public class ExcepcionPersonaje extends Exception{
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    /**
     * Excepción que ocntrola la validez de los atributos del personaje 
     * para la clase Personaje.
     * 
     * @param msj tipo String. El mensaje de la excepción.
     */
    public ExcepcionPersonaje(String msj){
        
        super (msj) ;
    }
}
