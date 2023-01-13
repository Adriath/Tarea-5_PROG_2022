
package modeladopersonaje;

import excepcionespersonaje.ExcepcionPersonaje;

/**
 * Clase en la que se modela a los personajes que van a participar en la batalla.
 * 
 * @author Adri�n Arjona
 */
public class Personaje {
    
     /* Francisco Adri�n Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    // ----------- ATRIBUTOS -----------------
    
    /* Constantes que nos servir�n para controlar el n�mero m�ximo de algunas 
    caracter�sticas de los personajes.
    */
    
    public final static byte MAX_FUERZA = 100 ;
    public final static byte MAX_INTELIGENCIA = 100 ;
    public final static byte MAX_VIDA = 100 ;
    public final static byte MIN_FUERZA = 0 ;
    public final static byte MIN_INTELIGENCIA = 0 ;
    public final static byte MIN_VIDA = 0 ;
    
    // Variable est�tica que se ir� incrementando con la creaci�n de cada personaje
    
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
    
    public Personaje(String nombre, byte inteligencia, byte fuerza) throws ExcepcionPersonaje{
        this.nombre = nombre ;
        this.vida = MAX_VIDA ;
        this.setInteligencia (inteligencia) ; // Lanza excepci�n si el valor no est� permitido.
        this.setFuerza(fuerza) ; // Lanza excepci�n si el valor no est� permitido.
        
        numeroPersonajes++ ;
    }
    
    // --------------- M�TODOS -----------------
    
        // GETTERS & SETTERS

            // Nombre
    
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

            // Inteligencia
        
        public byte getInteligencia() {
            return inteligencia;
        }

        public void setInteligencia(byte inteligencia) throws ExcepcionPersonaje{
            if ((inteligencia >= MIN_INTELIGENCIA) && (inteligencia <= MAX_INTELIGENCIA)) 
            {
                this.inteligencia = inteligencia ;
            }
            else
            {
                throw new ExcepcionPersonaje("\nEl valor no est� permitido. Debe ser mayor que " + MIN_INTELIGENCIA + 
                        " y menor que " + MAX_INTELIGENCIA + "\n") ;
            }
        }

            // Fuerza
        
        public byte getFuerza() {
            return fuerza;
        }

        public void setFuerza(byte fuerza) throws ExcepcionPersonaje{
            if ((fuerza >= MIN_FUERZA) && (fuerza <= MAX_FUERZA)) 
            {
                this.fuerza = fuerza ;
            }
            else
            {
                throw new ExcepcionPersonaje("\nEl valor no est� permitido. Debe ser mayor que " + MIN_FUERZA + 
                        " y menor que " + MAX_FUERZA + "\n") ;
            }
        }
        
        // TO STRING

        @Override
        public String toString() {
            return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + ", inteligencia=" + inteligencia + ", fuerza=" + fuerza + '}';
        }
 
    // ---------------- M�TODOS ------------------
        
    private void restarVida(){ // METODO PARA RESTAR VIDA
        
        if (this.vida > MIN_VIDA) // Si la vida del personaje es mayor que la vida m�nima...
        {
            this.vida -= 20 ; // ...r�stale 20 puntos de vida.
        }
        else // Si la vida est� por debajo del m�nimo...
        {
            this.vida = MIN_VIDA ; // ...que no sobrepase el valor m�nimo.
        }
    }
        
    public void batalla(Personaje p){ // M�TODO DE BATALLA
        
        short poderPersonaje1 ;
        short poderPersonaje2 ;
        
        poderPersonaje1 = (short)(this.fuerza + this.inteligencia) ;
        poderPersonaje2 = (short)(p.fuerza + p.inteligencia) ;
        
        
    }
}
