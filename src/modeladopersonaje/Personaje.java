
package modeladopersonaje;

import excepcionespersonaje.ExcepcionPersonaje;

/**
 * Clase en la que se modela a los personajes que van a participar en la batalla.
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
    
    public final static byte MAX_FUERZA = 100 ;
    public final static byte MAX_INTELIGENCIA = 100 ;
    public final static byte MAX_VIDA = 100 ;
    public final static byte MIN_FUERZA = 0 ;
    public final static byte MIN_INTELIGENCIA = 0 ;
    public final static byte MIN_VIDA = 0 ;
    
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
    
    public Personaje(String nombre, byte inteligencia, byte fuerza) throws ExcepcionPersonaje{
        this.nombre = nombre ;
        this.vida = MAX_VIDA ;
        this.setInteligencia (inteligencia) ; // Lanza excepción si el valor no está permitido.
        this.setFuerza(fuerza) ; // Lanza excepción si el valor no está permitido.
        
        numeroPersonajes++ ;
    }
    
    // --------------- MÉTODOS -----------------
    
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
                throw new ExcepcionPersonaje("\nEl valor no está permitido. Debe ser mayor que " + MIN_INTELIGENCIA + 
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
                throw new ExcepcionPersonaje("\nEl valor no está permitido. Debe ser mayor que " + MIN_FUERZA + 
                        " y menor que " + MAX_FUERZA + "\n") ;
            }
        }
        
        // TO STRING

        @Override
        public String toString() {
            return "Personaje{" + "nombre=" + nombre + ", vida=" + vida + ", inteligencia=" + inteligencia + ", fuerza=" + fuerza + '}';
        }
 
    // ---------------- MÉTODOS ------------------
        
    private void restarVida(){ // METODO PARA RESTAR VIDA
        
        if (this.vida > MIN_VIDA) // Si la vida del personaje es mayor que la vida mínima...
        {
            this.vida -= 20 ; // ...réstale 20 puntos de vida.
        }
        else // Si la vida está por debajo del mínimo...
        {
            this.vida = MIN_VIDA ; // ...que no sobrepase el valor mínimo.
        }
    }
    
    private void restarVida(byte puntosVida){ // MÉTODO PARA RESTAR VIDA CON PARÁMETROS
        
        if (this.vida > MIN_VIDA) // Si la vida del personaje es mayor que la vida mínima...
        {
            this.vida -= puntosVida ; // ...réstale los puntos de vida que se hayan pasado por parámetros.
        }
        else // Si la vida está por debajo del mínmo...
        {
            this.vida = MIN_VIDA ; // ...que no sobrepase el mínimo.
        }
    }
    
    public void valoresAleatorios(){ // MÉTODO PARA DAR VALORES ALEATORIOS
        
        byte fuerza ;
        byte inteligencia ;
        
        boolean validador = false ;
        
        do
        {
            fuerza = (byte)(Math.random()*MAX_FUERZA) ;
            inteligencia = (byte)(Math.random()*MAX_INTELIGENCIA) ;
            
            try
            {
                this.setFuerza(fuerza);
                this.setInteligencia(inteligencia);
                validador = true ;
            }
            catch (ExcepcionPersonaje e){ 
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            
        } while (!validador);
    }
    
        
    public void batalla(Personaje p){ // MÉTODO DE BATALLA
        
        short poderPersonaje1 ; // Personaje invocador del método.
        short poderPersonaje2 ; // Personaje pasado por parámetros.
        
        
        poderPersonaje1 = (short)(this.fuerza + this.inteligencia) ;
        poderPersonaje2 = (short)(p.fuerza + p.inteligencia) ;

        if (poderPersonaje1 > poderPersonaje2) // Si el P1 supera al P2...
        {
            p.restarVida(); // ...quita 20 puntos de vida a P2.
        }
        else if (poderPersonaje2 > poderPersonaje1) // Si ocurre al revés...
        {
            this.restarVida(); // ...quita 20 puntos de vida a P1.
        }
        else if (poderPersonaje1 == poderPersonaje2) // Si empatan...
        {
            this.restarVida(); // ...resta 20 puntos de vida a P1...
            p.restarVida(); // ...y a P2.
        }
        
    }
}
