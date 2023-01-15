
package app_personaje;

import excepcionespersonaje.ExcepcionPersonaje;
import modeladopersonaje.Personaje;
import utilidades.Utilidades;

/**
 * Clase que contiene el m�todo main. Contiene el men� de la aplicaci�n y todo 
 * lo requerido para librar batallas entre personajes.
 * 
 * @author Adri�n Arjona
 * @version 1.0 Enero 2023
 * @see https://imgur.com/a/4q3q6qV
 */
public class LanzadorPersonaje {
    
     /* Francisco Adri�n Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    /* Hola Adrián. Tienes que hacer lo siguiente:
     * - Debes mudar los métodos de aquí a la clase Personaje.
     * - Cambiar el método batalla() para que en vez de void sea booleano
     * - Añadir lo que falta del enunciado, como el empate en el final de la batalla
     * o los mensajes que tienen que aparecer.
     * - Ponerlo todo bonito, modificar los mensajes para darle vistosidad.
     */


    private static void mostrarMenu(){ // MUESTRA MEN�
        
        System.out.println("\n-------- MEN� --------\n");
        
        System.out.println("1. Crear personaje 1");
        System.out.println("2. Crear personaje 2");
        System.out.println("3. Batalla");
        System.out.println("4. Mostrar personajes");
        System.out.println("5. Modificar personaje 1");
        System.out.println("6. Modificar personaje 2");
        System.out.println("7. Salir");
    }
    
    private static void crearPersonaje(Personaje p){ // CREA PRESONAJE
        
        String nombre ;
        byte inteligencia ;
        byte fuerza ;
        
        boolean validador = false ;
        
        
        nombre = Utilidades.leerString("?Cu�l es su nombre?") ; // Pregunta el nombre del personaje
        p.setNombre(nombre); // Lo guarda en el objeto Personaje
        
        do 
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
                System.out.println("Alg�n error ocurri�.");
            }
            
        } while (!validador);
        
        validador = false ; // Reseteamos este valor para que funcione en el siguiente bucle.
            
        
        do 
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
                System.out.println("Alg�n error ocurri�.");
            }
            
            
        } while (!validador);
        
    }
    
    
    private static void modificaPersonaje(Personaje p){ // MODIFICA PRESONAJE
        
        String nombre ;
        byte inteligencia ;
        byte fuerza ;
        
        int opcion ;
        boolean validador = false ;
        
        do 
        {
            System.out.println("\n?Qu� atributo quieres modificar?\n");
            
            System.out.println("1. NOMBRE");
            System.out.println("2. INTELIGENCIA");
            System.out.println("3. FUERZA");
            System.out.println("4. TODO");
            System.out.println("5. DEJARLO COMO EST�");

            opcion = Utilidades.leerEntero("\nElige una opci�n:\n") ;
        
      
            switch (opcion)
            {
                case 1: // MODIFICA NOMBRE
                    
                    nombre = Utilidades.leerString("?C�mo quieres que se llame el personaje?") ;
                    p.setNombre(nombre);
                    
                    System.out.println("\nEl nombre del personaje ha sido modificado.\n");
                    
                    validador = true ;

                    break;
                
                case 2: // MODIFICA INTELIGENCIA
                    
                    do // Repite la instrucci�n hasta que los valores sean v�lidos.
                    {
                        try
                        {
                            inteligencia = Utilidades.leerByte("?Cu�ntos puntos de inteligencia quieres que tenga el personaje?") ;
                            p.setInteligencia(inteligencia);
                            
                            validador = true ;
                        }
                        catch (ExcepcionPersonaje e){
                            System.out.println(e.getMessage());
                        }
                        catch (Exception e){
                            System.out.println("Algo ocurri�.");
                        }
                        
                    } while (!validador);
                    
                    System.out.println("\nLa inteligencia del personaje  ha sido modificada.");
                    
                    break;
                    
                 case 3: // MODIFICA FUERZA
                    
                    do // Repite la instrucci�n hasta que los valores sean v�lidos.
                    {
                        try
                        {
                            fuerza = Utilidades.leerByte("?Cu�ntos puntos de fuerza quieres que tenga el personaje?") ;
                            p.setFuerza(fuerza);
                            
                            validador = true ;
                        }
                        catch (ExcepcionPersonaje e){
                            System.out.println(e.getMessage());
                        }
                        catch (Exception e){
                            System.out.println("Algo ocurri�.");
                        }
                        
                    } while (!validador);
                    
                     System.out.println("\nLa fuerza del personaje ha sido modificada.\n");
                    
                    break;
                    
                 case 4: // MODIFICA TODO
                     
                     crearPersonaje(p) ; // Este m�todo har� que se modifiquen todos los par�metros.
                     
                     System.out.println("\nEl personaje ha sido modificado.\n");
                     
                     validador = true ;
                     
                     break;
                     
                 case 5: // NO REALIZA NING�N CAMBIO
                     
                     System.out.println("\nNo se ha realizado ning�n cambio. Volviendo al men�.\n");
                     
                     validador = true ;
                     
                     break;
                     
                 default: // SI SE ESCOGE UNA OPCI�N NO V�LIDA
                     
                     System.out.println("\nDebes escoger una opci�n entre 1 y 5.\n");
                     
                     break;
                     
            }
            
        } while (!validador);
    }
    
    private static void muestraPersonajes(Personaje p1, Personaje p2){
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
    
    public static void main(String[] args) { // M�TODO MAIN

        try
        {
            String nombre = "";
            byte inteligencia = Personaje.MIN_INTELIGENCIA ;
            byte fuerza = Personaje.MAX_FUERZA ;

            int opcion ;
            boolean validador = false ;
            boolean personaje1Creado = false ;
            boolean personaje2Creado = false ;

            Personaje personaje1 = new Personaje(nombre, inteligencia, fuerza) ;
            Personaje personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
            
            Utilidades.leerString("Bienvenido al sistema, introduce la contrsae�o:"); // --------- SISTEMA PROVISIONAL DE CONTRASE�A -------------
                    System.out.println("Contrase�a correcta.");
            System.out.println("MENSAJE DE BIENVENIDA"); // ---------------------------- EDITAR ---------------------------
            
            do 
            {
            
                mostrarMenu();
            
                opcion = Utilidades.leerEntero("\nSELECCIONA UNA OPCI�N:\n") ;
            
                switch (opcion)
                {
                    case 1: // CREAR PERSONAJE 1
                    
                        if (!personaje1Creado) // Si el personaje no existe proceder� a su creaci�n.
                        {
                            System.out.println("\n-- Vas a crear el personaje 1 --\n");

                            crearPersonaje(personaje1) ;
                            
                            personaje1Creado = true ;
                        }
                        else // Si ya existe avisar� con un mensaje y volver� al men�.
                        {
                            System.out.println("\nEl personaje 1 ya ha sido creado.\n");
                        }

                        break;
                    
                    case 2: // CREAR PERSONAJE 2
                    
                        if (!personaje2Creado) // Si el personaje no existe proceder� a su creaci�n.
                        {
                            System.out.println("\n-- Vas a crear el personaje 2 --\n");

                            crearPersonaje(personaje2) ;

                            personaje2Creado = true ;
                        }
                        else // Si ya existe avisar� con un mensaje y volver� al men�.
                        {
                            System.out.println("\nEl personaje 2 ya ha sido creado.\n");
                        }

                        break;
                    
                    case 3: // BATALLA
                        
                        if (personaje1Creado & personaje2Creado) // Si los personajes han sido creados proceder� a la batalla.
                        {
                            personaje1.batalla(personaje2);
                            
                            if (personaje1.compruebaVida()) 
                            {
                                System.out.println("GANA EL PERSONAJE 2"); // -------------- PROVISIONAL
                                
                                validador = true ;
                            }
                            else if (personaje2.compruebaVida()) 
                            {
                                System.out.println("GANA EL PERSONAJE 1"); // -------------- PROVISIONAL
                                
                                validador = true ;
                            }
                            
                            personaje1.valoresAleatorios();
                            personaje2.valoresAleatorios();
                        }
                        else // Si los personajes no est�n creados avisar� con un mensaje y saldr� al men�.
                        {
                            System.out.println("Debes crear primero los personajes.");
                        }
                        
                        break;
                    
                    case 4: // MOSTRAR PERSONAJES
                    
                        if (personaje1Creado & personaje2Creado) // Si los peronsajes est�n creados los muestra.
                        {
                            muestraPersonajes(personaje1, personaje2);
                        }
                        else // Si los personajes no est�n creados avisar� con un mensaje y no los mostrar�.
                        {
                            System.out.println("\nTienes que crear primero los personajes.\n");
                        }
                        
                        break ;
                    
                    case 5: // MODIFICAR PERSONAJE 1
                        
                        if (personaje1Creado) // Si el personaje est� creado lo modificar�.
                        {
                            System.out.println("\n-- EST�S MODIFICANDO EL PERSONAJE 1 --\n");
                            
                            modificaPersonaje(personaje1);
                        }
                        else // Si no est� creado avisar� y saldr� al men�.
                        {
                            System.out.println("\nEl personaje 1 no est� creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 6: // MODIFICAR PERSONAJE 2
                        
                        if (personaje1Creado) // Si el personaje est� creado lo modificar�.
                        {
                            System.out.println("\n-- EST�S MODIFICANDO EL PERSONAJE 2 --\n");
                            
                            modificaPersonaje(personaje2);
                        }
                        else // Si no est� creado avisar� y saldr� al men�.
                        {
                            System.out.println("\nEl personaje 2 no est� creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 7: // SALIR
                    
                        validador = true ; // ------------- SALIDA PROVISIONAL ------------------
                        
                        break ;
                        
                    default:
                        
                        System.out.println("\nTienes que escoger una opci�n entre 1 y 7.\n");
                        
                        break;
                }
            } while (!validador);
            
            System.out.println("------ MENSAJE DESEPDIDA -----------"); // --------------- TENGO QUE CAMBIAR ESTO
            
        }
        catch (ExcepcionPersonaje e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
} // Esto es una prueba de sincronización con la tablet. Si aparece es que todo bien.
