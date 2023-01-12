
package modeladopersonaje;

import excepcionespersonaje.ExcepcionPersonaje;

/**
 *
 * @author Adrián Arjona
 */
public class Personaje {
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    // ----------- ATRIBUTOS -----------------
    
    /* Constantes que nos servirán para controlar el número máximo de algunas 
    características de los personajes.
    */
    
    final static byte MAX_FUERZA = 100 ;
    final static byte MAX_INTELIGENCIA = 100 ;
    final static byte MAX_VIDA = 100 ;
    final static byte MIN_FUERZA = 0 ;
    final static byte MIN_INTELIGENCIA = 0 ;
    final static byte MIN_VIDA = 0 ;
    
    // Variable estática que se irá incrementando con la creación de cada personaje
    
    public static short numeroPersonajes ;
    
    // Nombre, vida, inteligencia y fuerza del personaje.
    
    private String nombre ;
    private byte vida ;
    private byte inteligencia ;
    private byte fuerza ;

    
    // ------------ CONSTRUCTORES --------------
    
    public Personaje() {
        this.nombre = "S/N" ;
        this.vida = MAX_VIDA ;
        this.inteligencia = MIN_INTELIGENCIA ;
        this.fuerza = MIN_FUERZA;
        
        numeroPersonajes++ ;
    }
    
//    public Personaje(String nombre, byte inteligencia, byte fuerza) throws ExcepcionPersonaje{
//        this.nombre = nombre ;
//        this.vida = MAX_VIDA ;
//        this.setInteligencia (inteligencia) ;
//        this.setFuerza(fuerza) ;
//        
//        numeroPersonajes** ;
//    }
    
    
}
