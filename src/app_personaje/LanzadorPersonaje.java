
package app_personaje;

import excepcionespersonaje.ExcepcionPersonaje;
import modeladopersonaje.Personaje;
import utilidades.Utilidades;

/**
 * Clase que contiene el método main. Contiene el menú de la aplicación y todo 
 * lo requerido para librar batallas entre personajes.
 * 
 * @author Adrián Arjona
 * @version 1.0 Enero 2023
 * @see https://imgur.com/a/4q3q6qV
 */
public class LanzadorPersonaje {
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
    private static void mostrarMenu(){ // MUESTRA MENÚ
        
        System.out.println("\n-------- MENÚ --------\n");
        
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
        
        
        nombre = Utilidades.leerString("?Cuál es su nombre?") ; // Pregunta el nombre del personaje
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
                System.out.println("Algún error ocurrió.");
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
                System.out.println("Algún error ocurrió.");
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
            System.out.println("\n?Qué atributo quieres modificar?\n");
            
            System.out.println("1. NOMBRE");
            System.out.println("2. INTELIGENCIA");
            System.out.println("3. FUERZA");
            System.out.println("4. TODO");
            System.out.println("5. DEJARLO COMO ESTÁ");

            opcion = Utilidades.leerEntero("\nElige una opción:\n") ;
        
      
            switch (opcion)
            {
                case 1: // MODIFICA NOMBRE
                    
                    nombre = Utilidades.leerString("?Cómo quieres que se llame el personaje?") ;
                    p.setNombre(nombre);
                    
                    System.out.println("\nEl nombre del personaje ha sido modificado.\n");
                    
                    validador = true ;

                    break;
                
                case 2: // MODIFICA INTELIGENCIA
                    
                    do // Repite la instrucción hasta que los valores sean válidos.
                    {
                        try
                        {
                            inteligencia = Utilidades.leerByte("?Cuántos puntos de inteligencia quieres que tenga el personaje?") ;
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
                    
                    System.out.println("\nLa inteligencia del personaje ha sido modificada.");
                    
                    break;
                    
                 case 3: // MODIFICA FUERZA
                    
                    do // Repite la instrucción hasta que los valores sean válidos.
                    {
                        try
                        {
                            fuerza = Utilidades.leerByte("?Cuántos puntos de fuerza quieres que tenga el personaje?") ;
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
                     
                     crearPersonaje(p) ; // Este método hará que se modifiquen todos los parámetros.
                     
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
    
    
    public static void main(String[] args) { // MÉTODO MAIN

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
            
            
            System.out.println("MENSAJE DE BIENVENIDA"); // ---------------------------- EDITAR ---------------------------
            
            do 
            {
            
                mostrarMenu();
            
                opcion = Utilidades.leerEntero("\nSELECCIONA UNA OPCIÓN:\n") ;
            
                switch (opcion)
                {
                    case 1: // CREAR PERSONAJE 1
                    
                        if (!personaje1Creado) // Si el personaje no existe procederá a su creación.
                        {
                            System.out.println("\n-- Vas a crear el personaje 1 --\n");

                            crearPersonaje(personaje1) ;
                            
                            personaje1Creado = true ;
                        }
                        else // Si ya existe avisará con un mensaje y volverá al menú.
                        {
                            System.out.println("\nEl personaje 1 ya ha sido creado.\n");
                        }

                        break;
                    
                    case 2: // CREAR PERSONAJE 2
                    
                        if (!personaje2Creado) // Si el personaje no existe procederá a su creación.
                        {
                            System.out.println("\n-- Vas a crear el personaje 2 --\n");

                            crearPersonaje(personaje2) ;

                            personaje2Creado = true ;
                        }
                        else // Si ya existe avisará con un mensaje y volverá al menú.
                        {
                            System.out.println("\nEl personaje 2 ya ha sido creado.\n");
                        }

                        break;
                    
                    case 3: // BATALLA
                        
                        if (personaje1Creado & personaje2Creado) // Si los personajes han sido creados procederá a la batalla.
                        {
                            
                        }
                        else // Si los personajes no están creados avisará con un mensaje y saldrá al menú.
                        {
                            System.out.println("Debes crear primero los personajes.");
                        }
                        
                        break;
                    
                    case 4: // MOSTRAR PERSONAJES
                    
                        if (personaje1Creado & personaje2Creado) // Si los peronsajes están creados los muestra.
                        {
                            System.out.println(personaje1.toString());
                            System.out.println(personaje2.toString());
                        }
                        else // Si los personajes no están creados avisará con un mensaje y no los mostrará.
                        {
                            System.out.println("\nTienes que crear primero los personajes.\n");
                        }
                        
                        break ;
                    
                    case 5: // MODIFICAR PERSONAJE 1
                        
                        if (personaje1Creado) // Si el personaje está creado lo modificará.
                        {
                            System.out.println("\n-- ESTÁS MODIFICANDO EL PERSONAJE 1 --\n");
                            
                            modificaPersonaje(personaje1);
                        }
                        else // Si no está creado avisará y saldrá al menú.
                        {
                            System.out.println("\nEl personaje 1 no está creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 6: // MODIFICAR PERSONAJE 2
                        
                        if (personaje1Creado) // Si el personaje está creado lo modificará.
                        {
                            System.out.println("\n-- ESTÁS MODIFICANDO EL PERSONAJE 2 --\n");
                            
                            modificaPersonaje(personaje2);
                        }
                        else // Si no está creado avisará y saldrá al menú.
                        {
                            System.out.println("\nEl personaje 2 no está creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 7: // SALIR
                    
                    default:
                        
                        System.out.println("\nTienes que escoger una opción entre 1 y 7.\n");
                        
                        break;
                }
            } while (!validador);
        }
        catch (ExcepcionPersonaje e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
