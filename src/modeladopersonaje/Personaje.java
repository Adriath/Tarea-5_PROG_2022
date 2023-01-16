
package modeladopersonaje;

import excepcionespersonaje.ExcepcionPersonaje;
import utilidades.Utilidades;

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
    
    /**
     * Constructor por defecto de la clase Personaje.
     */
    public Personaje() {
        this.nombre = "S/N" ;
        this.vida = MAX_VIDA ;
        this.inteligencia = MIN_INTELIGENCIA ;
        this.fuerza = MIN_FUERZA;
        
        numeroPersonajes++ ;
    }
    
    /**
     * Constructor con parámetros de la clase Personaje.
     * Los valores tienen que estar entre los mínimos y máximo permitidos.
     * 
     * @param nombre String. Nombre del personaje.
     * @param inteligencia byte. Inteligencia del personaje.
     * @param fuerza byte. Fuerza del personaje.
     * @throws ExcepcionPersonaje 
     */
    public Personaje(String nombre, byte inteligencia, byte fuerza) throws ExcepcionPersonaje{
        this.nombre = nombre ;
        this.vida = MAX_VIDA ;
        this.setInteligencia (inteligencia) ; // Lanza excepción si el valor no está permitido.
        this.setFuerza(fuerza) ; // Lanza excepción si el valor no está permitido.
        
        numeroPersonajes++ ;
    }
    
    // --------------- METODOS -----------------
    
        // GETTERS & SETTERS

            // Nombre
    
        /**
         * Método que muestra el nombre del personaje.
         * 
         * @return Tipo String. Devuelve el nombre del personaje.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Método que modifica el nombre del personaje.
         * 
         * @param nombre String. Nombre del personaje.
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

            // Inteligencia
        
        /**
         * Método que muestra la inteligencia del personaje.
         * 
         * @return Tipo byte. Devuelve la inteligencia del personaje.
         */
        public byte getInteligencia() {
            return inteligencia;
        }

        /**
         * Método que modifica la inteligencia del personaje.
         * El valor tiene que estar entre los valores permitidos.
         * 
         * @param inteligencia byte. Inteligencia del personaje.
         * @throws ExcepcionPersonaje 
         */
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
        
        /**
         * Método que muestra la fuerza del personaje.
         * 
         * @return 
         */
        public byte getFuerza() {
            return fuerza;
        }

        /**
         * Método que modifica la fuerza del personaje.
         * El valor tiene que estar entre los valores permitidos.
         * 
         * @param fuerza byte. Fuerza del personaje.
         * @throws ExcepcionPersonaje 
         */
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

        @Override // -------------------------------- MODIFICAAAAAAAAAAAAAAAAAR --------------------
        public String toString() {
            
            return "NOMBRE: " + nombre + "\n\n"
                    + "\tVIDA: " + vida + "\n"
                    + "\tFUERZA: " + fuerza + "\n"
                    + "\tINTELIGENCIA: " + inteligencia + "\n" ;
        }
 
    // ---------------- MÉTODOS ------------------

    
    /**
     * Método que crea el personaje de cara al usuario/a. No confundir con el 
     * constructor. Este método realmente modifica los parámetros de un objeto 
     * ya creado pero lo utilizaremos en un contexto en que supondrá una creación, 
     * la creación del personaje y no del objeto.
     * 
     * @param p Tipo Personaje. El personaje que vamos a modificar.
     */
    public static void crearPersonaje(Personaje p){
        
        String nombre ;
        byte inteligencia ;
        byte fuerza ;
        
        boolean validador = false ;
        boolean creado = false ; // Valdrá para dar el personaje por creado.
        
        
        nombre = Utilidades.leerString("¿Cuál es su nombre?") ; // Pregunta el nombre del personaje
        p.setNombre(nombre); // Lo guarda en el objeto Personaje
        
        do // Se repetirá hasta que el valor del atributo fuerza sea el permitido.
        {
            try
            {
                inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA +  // Pregunta por la inteligencia del personaje
                " y " + Personaje.MAX_INTELIGENCIA + "):") ;
            
                p.setInteligencia(inteligencia); // Lo guarda en el  objeto Personaje
                
                validador = true ;
            }
            catch (ExcepcionPersonaje e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Algún error ocurrió.");
            }
            
        } while (!validador);
        
        validador = false ; // Reseteamos este valor para que funcione en el siguiente bucle.
            
        
        do // Se repetirá hasta que el valor del atributo inteligencia sea el permitido.
        {
            try
            {
                fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + // Pregunta por la fuerza del personaje
                " y " + Personaje.MAX_FUERZA + "):") ;
                
                p.setFuerza(fuerza); // Lo guarda en el objeto Personaje
                
                validador = true ;
            }
            catch (ExcepcionPersonaje e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Algún error ocurrió.");
            }
            
            
        } while (!validador);
        
    }
        
    
    /**
     * Método que modifica algún atributo del personaje. Desplegará un menú de 
     * opciones que permitirá cambiar alguno de los atributos, todos o ninguno.
     * 
     * @param p Tipo Personaje. Objeto personaje que deseamos modificar.
     */
    public static void modificaPersonaje(Personaje p){
        
        String nombre ;
        byte inteligencia ;
        byte fuerza ;
        
        int opcion ;
        boolean validador = false ;
        
        do 
        {
            System.out.println("\n¿Qué atributo quieres modificar?\n");
            
            System.out.println("1. NOMBRE");
            System.out.println("2. INTELIGENCIA");
            System.out.println("3. FUERZA");
            System.out.println("4. TODO");
            System.out.println("5. DEJARLO COMO ESTÁ");

            opcion = Utilidades.leerEntero("\nElige una opción:\n") ;
        
      
            switch (opcion)
            {
                case 1: // MODIFICA NOMBRE
                    
                    nombre = Utilidades.leerString("¿Cómo quieres que se llame el personaje?") ;
                    p.setNombre(nombre);
                    
                    System.out.println("\nEl nombre del personaje ha sido modificado.\n");
                    
                    validador = true ;

                    break;
                
                case 2: // MODIFICA INTELIGENCIA
                    
                    do // Repite la instrucción hasta que los valores sean válidos.
                    {
                        try
                        {
                            inteligencia = Utilidades.leerByte("¿Cuántos puntos de inteligencia quieres que tenga el personaje?") ;
                            p.setInteligencia(inteligencia);
                            
                            validador = true ;
                        }
                        catch (ExcepcionPersonaje e){
                            System.out.println(e.getMessage());
                        }
                        catch (Exception e){
                            System.out.println("Algo ocurrió.");
                        }
                        
                    } while (!validador);
                    
                    System.out.println("\nLa inteligencia del personaje  ha sido modificada.");
                    
                    break;
                    
                 case 3: // MODIFICA FUERZA
                    
                    do // Repite la instrucción hasta que los valores sean válidos.
                    {
                        try
                        {
                            fuerza = Utilidades.leerByte("¿Cuántos puntos de fuerza quieres que tenga el personaje?") ;
                            p.setFuerza(fuerza);
                            
                            validador = true ;
                        }
                        catch (ExcepcionPersonaje e){
                            System.out.println(e.getMessage());
                        }
                        catch (Exception e){
                            System.out.println("Algo ocurrió.");
                        }
                        
                    } while (!validador);
                    
                     System.out.println("\nLa fuerza del personaje ha sido modificada.\n");
                    
                    break;
                    
                 case 4: // MODIFICA TODO
                     
                     Personaje.crearPersonaje(p) ; // Este método hará que se modifiquen todos los parámetros, lo vuelve a crear aunque sobre el mismo objeto.
                     
                     System.out.println("\nEl personaje ha sido modificado.\n");
                     
                     validador = true ;
                     
                     break;
                     
                 case 5: // NO REALIZA NINGÚN CAMBIO
                     
                     System.out.println("\nNo se ha realizado ningún cambio. Volviendo al menú.\n");
                     
                     validador = true ;
                     
                     break;
                     
                 default: // SI SE ESCOGE UNA OPCIÓN NO VÁLIDA
                     
                     System.out.println("\nDebes escoger una opción entre 1 y 5.\n");
                     
                     break;
                     
            }
            
        } while (!validador);
    }
    
    
    /**
     * Método que muestra los valores de dos personajes al mismo tiempo.
     * 
     * @param p1 Tipo Personaje. Objeto que corresponde al personaje 1.
     * @param p2 Tipo Personaje. Objeto que corresponde al personaje 2.
     */
    public static void muestraPersonajes(Personaje p1, Personaje p2){
        
        System.out.println("\nDATOS DEL COMBATIENTE 1");
        System.out.println("-----------------------");
        System.out.println(p1.toString());
        
        System.out.println("\nDATOS DEL COMBATIENTE 2");
        System.out.println("-----------------------");
        System.out.println(p2.toString());
    }
        
    
    /**
     * Método que resta vida al personaje.
     */
    private void restarVida(){
        
        if (this.vida > MIN_VIDA) // Si la vida del personaje es mayor que la vida mínima...
        {
            this.vida -= 20 ; // ...réstale 20 puntos de vida.
        }
        else // Si la vida está por debajo del mínimo...
        {
            this.vida = MIN_VIDA ; // ...que no sobrepase el valor mínimo.
        }
    }
    
    
    /**
     * Método que resta vida al personaje con parámetros.
     * 
     * @param puntosVida byte. Son los puntos de vida que queremos restar.
     */
    private void restarVida(byte puntosVida){
        
        if (this.vida > MIN_VIDA) // Si la vida del personaje es mayor que la vida mínima...
        {
            this.vida -= puntosVida ; // ...réstale los puntos de vida que se hayan pasado por parámetros.
        }
        else // Si la vida está por debajo del mínimo...
        {
            this.vida = MIN_VIDA ; // ...que no sobrepase el mínimo.
        }
    }
    
    
    /**
     * Método que calcula valores aleatorios para los atributos del personaje 
     * de cara a las próximas batallas.
     */
    public void valoresAleatorios(){
        
        byte fuerza ;
        byte inteligencia ;
        
        boolean validador = false ;
        
        do // Este bucle puede ser redundante.
        {
            fuerza = (byte)(Math.random()*MAX_FUERZA) ; // Calcula un número comprendido entre los valores mínimos y  máximos para la fuerza.
            inteligencia = (byte)(Math.random()*MAX_INTELIGENCIA) ; // Calcula un número comprendido entre los valores mínimos y  máximos para la inteligencia.
            
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
    
    
    /**
     * Método que comprueba la vida del personaje para saber si está vivo o muerto.
     * 
     * @return Tipo boolean. Devuelve true si la vida del personaje es igual a la vida mínima (muerto).
     */
    public boolean compruebaVida(){
        
        boolean muerto = false ;
        
        if (this.vida == MIN_VIDA) { // Si la vida del personaje es igual a la vida mínima...
            
            muerto = true ; // ...el personaje habrá muerto.
        }
        
        return muerto ;
    }
    
        
    /**
     * Método que enfrenta a dos personajes en una batalla.
     * Mostrará los atributos de los personajes antes y después de la batalla,
     * restará vida al más débil y modificará los atributos si siguen vivos.
     * Si alguno de los dos muere (o los dos) mostrará un mensaje.
     * 
     * @param p
     * @return 
     */
    public boolean batalla(Personaje p){
        
        // -- ANTES DE LA BATALLA --
        
        short poderPersonaje1 ; // Personaje invocador del método.
        short poderPersonaje2 ; // Personaje pasado por parámetros.
        
        boolean finalizaBatalla = false ; // Determina cuando la batalla finaliza por muerte de un personaje.
        
        // Se suman los atributos de cada personajes para posteriormente compararlos.
        
        poderPersonaje1 = (short)(this.fuerza + this.inteligencia) ; // Fuerza más inteligencia del personaje 1.
        poderPersonaje2 = (short)(p.fuerza + p.inteligencia) ; // Fuerza más inteligencia del personaje 2.

        // Mueszra el estado de cada personaje antes de la batalla.
        
        muestraPersonajes(this, p);
        
        // ¡Comienza la lucha!
        
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
        
        // -- DESPUÉS DE LA BATALLA --
        
        // En caso de que gane algún personaje mostrará el mensaje. Si sobreviven pasamos directamente al else.
        
        if ((this.compruebaVida()) & !(p.compruebaVida())) // --> Si personaje 1 muere pero personaje 2 sobrevive: gana personaje 2.
        {
            System.out.println("██    ██ ███████ ███    ██  ██████ ███████      ██████  ██████  ███    ███ ██████   █████  ████████ ██ ███████ ███    ██ ████████ ███████     ██████  \n" +
"██    ██ ██      ████   ██ ██      ██          ██      ██    ██ ████  ████ ██   ██ ██   ██    ██    ██ ██      ████   ██    ██    ██               ██ \n" +
"██    ██ █████   ██ ██  ██ ██      █████       ██      ██    ██ ██ ████ ██ ██████  ███████    ██    ██ █████   ██ ██  ██    ██    █████        █████  \n" +
" ██  ██  ██      ██  ██ ██ ██      ██          ██      ██    ██ ██  ██  ██ ██   ██ ██   ██    ██    ██ ██      ██  ██ ██    ██    ██          ██      \n" +
"  ████   ███████ ██   ████  ██████ ███████      ██████  ██████  ██      ██ ██████  ██   ██    ██    ██ ███████ ██   ████    ██    ███████     ███████ \n" +
"                                                                                                                                                      \n" +
"                                                                                                                                                      "); // -------------- PROVISIONAL

            System.out.println("// En un enfrentamiento directo está claro que ganaría " + p.getNombre() + "."
                    + "\n// Hemos obtenido interesantes datos de este combate. Anotando posibles mejoras en el Compuesto V.\n");
            
            finalizaBatalla = true ;
        }
        else if ((p.compruebaVida()) & !(this.compruebaVida())) // --> Si personaje 2 muere pero personaje 1 sobrevive: gana personaje 1.
        {
            System.out.println("██    ██ ███████ ███    ██  ██████ ███████      ██████  ██████  ███    ███ ██████   █████  ████████ ██ ███████ ███    ██ ████████ ███████      ██ \n" +
"██    ██ ██      ████   ██ ██      ██          ██      ██    ██ ████  ████ ██   ██ ██   ██    ██    ██ ██      ████   ██    ██    ██          ███ \n" +
"██    ██ █████   ██ ██  ██ ██      █████       ██      ██    ██ ██ ████ ██ ██████  ███████    ██    ██ █████   ██ ██  ██    ██    █████        ██ \n" +
" ██  ██  ██      ██  ██ ██ ██      ██          ██      ██    ██ ██  ██  ██ ██   ██ ██   ██    ██    ██ ██      ██  ██ ██    ██    ██           ██ \n" +
"  ████   ███████ ██   ████  ██████ ███████      ██████  ██████  ██      ██ ██████  ██   ██    ██    ██ ███████ ██   ████    ██    ███████      ██ \n" +
"                                                                                                                                                  \n" +
"                                                                                                                                                  "); // -------------- PROVISIONAL

            System.out.println("// Tras analizar los datos llegamos a la conclusión de que " + this.nombre + " aplastaría a su rival."
                    + "\n// Los datos resultan inquietantes, sugiero reforzar la vigilancia del grupo conocido como The Boys por su alta peligrosidad.\n");
            
            finalizaBatalla = true ;
        }
        else if ((this.compruebaVida()) & (p.compruebaVida())) // --> Si ambos mueren: empate.
        {
            System.out.println("███████ ███    ███ ██████   █████  ████████ ███████ \n" +
"██      ████  ████ ██   ██ ██   ██    ██    ██      \n" +
"█████   ██ ████ ██ ██████  ███████    ██    █████   \n" +
"██      ██  ██  ██ ██      ██   ██    ██    ██      \n" +
"███████ ██      ██ ██      ██   ██    ██    ███████ \n" +
"                                                    \n" +
"                                                    ");
            
            System.out.println("// Reportando error del sistema, esto no debería pasar."
                    + "\n// Quizás haya llegado el momento de hacer cambios en la división informática.\n");
            
            finalizaBatalla = true ;
        }
        else // --> Si los peronajes han sobrevivido continúa el código para preparar la siguiente batalla.
        {
            this.valoresAleatorios(); // Modificamos atributos aleatoriamente del personaje 1.
            p.valoresAleatorios(); // Modificamos atributos aleatoriamente del personaje 2.
        
            System.out.println("\n -- Teniendo en cuenta las condiciones de la batalla se han actualizado los parámetros de los combatientes.-- \n");
        }

        // Mostramos de nuevo el estado de los personajes tras haber librado la batalla.
        
        System.out.println("\n-- RESULTADOS TRAS LA BATALLA --\n");
        muestraPersonajes(this, p);
    
        return finalizaBatalla ;        
    }
}
