
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
    
    /* Hola Adrián. Tienes que hacer lo siguiente:
     * - Debes mudar los métodos de aquí­ a la clase Personaje.
     * - Cambiar el método batalla() para que en vez de void sea booleano
     * - Aħadir lo que falta del enunciado, como el empate en el final de la batalla
     * o los mensajes que tienen que aparecer.
     * - Ponerlo todo bonito, modificar los mensajes para darle vistosidad.
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
    
    
    public static void main(String[] args) { // -------------------- MÉTODO MAIN -----------------------------

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
            
            Utilidades.leerString("Bienvenido al sistema, introduce la contraseña:"); // --------- SISTEMA PROVISIONAL DE CONTRASEïż½A -------------
                    System.out.println("Contraseña correcta.");
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

                            Personaje.crearPersonaje(personaje1) ;
                            
                            personaje1Creado = true ;
                        }
                        else // Si ya existe avisará con un mensaje y volverá al menú.
                        {
                            System.out.println("\nEl personaje 1 ya ha sido creado.\n");
                        }

                        break;
                    
                    case 2: // CREAR PERSONAJE 2
                    
                        if (!personaje2Creado) // Si el personaje no existe prcederá a su creación.
                        {
                            System.out.println("\n-- Vas a crear el personaje 2 --\n");

                            Personaje.crearPersonaje(personaje2) ;

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
                            validador = personaje1.batalla(personaje2);
                        }
                        else // Si los personajes no están creados avisará con un mensaje y saldrá al menú.
                        {
                            System.out.println("Debes crear primero los personajes.");
                        }
                        
                        break;
                    
                    case 4: // MOSTRAR PERSONAJES
                    
                        if (personaje1Creado & personaje2Creado) // Si los peronsajes están creados los muestra.
                        {
                            Personaje.muestraPersonajes(personaje1, personaje2);
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
                            
                            Personaje.modificaPersonaje(personaje1);
                        }
                        else // Si no está creado avisará y saldrá al menú.
                        {
                            System.out.println("\nEl personaje e1 no está creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 6: // MODIFICAR PERSONAJE 2
                        
                        if (personaje2Creado) // Si el personaje está creado lo modificará.
                        {
                            System.out.println("\n-- ESTÁS MODIFICANDO EL PERSONAJE 2 --\n");
                            
                            Personaje.modificaPersonaje(personaje2);
                        }
                        else // Si no está creado avisará y saldrá al menú.
                        {
                            System.out.println("\nEl personaje 2 no está creado. Debes crearlo primero.\n");
                        }
                        
                        break;
                        
                    case 7: // SALIR
                    
                        validador = true ; // ------------- SALIDA PROVISIONAL ------------------
                        
                        break ;
                        
                    default:
                        
                        System.out.println("\nTienes que escoger una opción entre 1 y 7.\n");
                        
                        break;
                }
            } while (!validador);
            
            System.out.println("------ MENSAJE DESPEDIDA -----------"); // --------------- TENGO QUE CAMBIAR ESTO
            
        }
        catch (ExcepcionPersonaje e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
