
package app_personaje;

import excepcionespersonaje.ExcepcionPersonaje;
import modeladopersonaje.Personaje;
import utilidades.Utilidades;

/**
 * Clase que contiene el método main. Contiene el menú de la aplicación y todo 
 * lo requerido para librar batallas entre personajes.
 * La temática está basada en una veñta del cómic The Boys. En esta misma 
 * descripción está el enlace para ver la imagen.
 * 
 * @author Adrián Arjona
 * @version 1.0 Enero 2023
 * @see https://imgur.com/a/4q3q6qV
 */
public class LanzadorPersonaje {
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */


    /**
     * Método estático que muestra el menú para la aplicación de combates.
     */
    private static void mostrarMenu(){
        
        System.out.println("\n-------- MENÚ --------\n");
        
        System.out.println("1. Crear personaje 1");
        System.out.println("2. Crear personaje 2");
        System.out.println("3. Batalla");
        System.out.println("4. Mostrar personajes");
        System.out.println("5. Modificar personaje 1");
        System.out.println("6. Modificar personaje 2");
        System.out.println("7. Salir");
    }
    
    
    // ------------------------------------------------------------
    // -------------------- MÉTODO MAIN ---------------------------
    // ------------------------------------------------------------
    
    
    public static void main(String[] args) {

        try
        {
            // ---------- DECLARACIÓN DE ATRIBUTOS -------------
            
            String nombre = "";
            byte inteligencia = Personaje.MIN_INTELIGENCIA ;
            byte fuerza = Personaje.MAX_FUERZA ;

            int opcion ; // Opción del menú
            int contadorBatalla = 1 ; // Cuenta el número de batallas que se libran
            
            boolean validador = false ; // Para salir del bucle
            boolean personaje1Creado = false ; // Indica si el personaje 1 ha sido creado
            boolean personaje2Creado = false ; // Indica si el personaje 2 ha sido creado

            // ------------ CONSTRUCCIÓN OBJETOS ---------------
            
            Personaje personaje1 = new Personaje(nombre, inteligencia, fuerza) ;
            Personaje personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
            
            // --------------- MENSAJE BIENVENIDA --------------------
            
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println(" __      __                          _       _                                            _                        \n" +
" \\ \\    / /                         | |     | |         /\\                               (_)                       \n" +
"  \\ \\  / /    ___    _   _    __ _  | |__   | |_       /  \\     _ __ ___     ___   _ __   _    ___    __ _   _ __  \n" +
"   \\ \\/ /    / _ \\  | | | |  / _` | | '_ \\  | __|     / /\\ \\   | '_ ` _ \\   / _ \\ | '__| | |  / __|  / _` | | '_ \\ \n" +
"    \\  /    | (_) | | |_| | | (_| | | | | | | |_     / ____ \\  | | | | | | |  __/ | |    | | | (__  | (_| | | | | |\n" +
"     \\/      \\___/   \\__,_|  \\__, | |_| |_|  \\__|   /_/    \\_\\ |_| |_| |_|  \\___| |_|    |_|  \\___|  \\__,_| |_| |_|\n" +
"                              __/ |                                                                                \n" +
"                             |___/                                                                                 ");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            
            System.out.println("\n\t¡BRECHA DE SEGURIDAD DETECTADA!\n");
            
            Utilidades.leerString("\nIntroduce la contraseña para continuar:"); 
                    System.out.println("Contraseña correcta.\n");
                        
            System.out.println("\nCARGANDO\n");
            System.out.println("********** 18%");
            System.out.println("********************************* 37%");
            System.out.println("**************************************************************************** 68%");
            System.out.println("**************************************************************************************************** 79%");
            System.out.println("**************************************************************************************************************************** 100%\n");
            
            System.out.println("Has accedido a una zona restringida del sistema. AVISO. Software experimental en fase de pruebas, los datos pueden no ser fiables.");
            System.out.println("\n--- CARGANDO EL SIMULAODR DE ENFRENTAMIENTOS ---\n");
            
            System.out.println("El siguiente software desarrollado por Vought American® permite simular el enfrentamiento entre "
                    + "\nmiembros de The Seven y The Boys. También pueden simularse otras situaciones."
                    + "\nCon ello se pretende predecir el rumbo que tomará la tregua y estar preparados para los riesgos que tenemos que asumir.");
            
            
            // ------------ OPERACIONES ----------------
            
            do // Sirve para mantenernos en el menú
            {
                mostrarMenu(); // Muestra el menú al usuario/a

                opcion = Utilidades.leerEntero("\nSELECCIONA UNA OPCIÓN:\n") ; // Pide la opción al usuario/a

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

                        if (!personaje2Creado) // Si el personaje no existe procederá a su creación.
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
                            System.out.println("\nBATALLA " + contadorBatalla + "\n"); // Mensaje que indica el número de batalla que se está librando.
                            
                            validador = personaje1.batalla(personaje2);
                            
                            contadorBatalla++ ;
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
                            System.out.println("\nEl personaje 1 no está creado. Debes crearlo primero.\n");
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

                        validador = !(Utilidades.secuenciaSalida()) ; // El/la usuario/a debe seleccionar "S" o "s" para salir del programa.

                        break ;

                    default: // SI NO SE ELIGE UNA OPCIÓN VÁLIDA

                        System.out.println("\nTienes que escoger una opción entre 1 y 7.\n");

                        break;
                }

            } while (!validador);
            
            // ---------------- MENSAJE DESPEDIDA -----------------
            
            if (personaje1Creado && personaje2Creado) 
            {
                System.out.println("\nSe han creado " + Personaje.numeroPersonajes + " combatientes.\n");
            }
            else if (personaje1Creado | personaje2Creado) 
            {
                System.out.println("\nSe ha creado 1 combatiente.\n");
            }
                        
            System.out.println("\n------------------------------");
            System.out.println("\tCERRANDO SISTEMA");
            System.out.println("------------------------------\n");
            
            System.out.println("\nHACIENDO TU VIDA MÁS SEGURA.\n");
            
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println(" __      __                          _       _                                            _                        \n" +
" \\ \\    / /                         | |     | |         /\\                               (_)                       \n" +
"  \\ \\  / /    ___    _   _    __ _  | |__   | |_       /  \\     _ __ ___     ___   _ __   _    ___    __ _   _ __  \n" +
"   \\ \\/ /    / _ \\  | | | |  / _` | | '_ \\  | __|     / /\\ \\   | '_ ` _ \\   / _ \\ | '__| | |  / __|  / _` | | '_ \\ \n" +
"    \\  /    | (_) | | |_| | | (_| | | | | | | |_     / ____ \\  | | | | | | |  __/ | |    | | | (__  | (_| | | | | |\n" +
"     \\/      \\___/   \\__,_|  \\__, | |_| |_|  \\__|   /_/    \\_\\ |_| |_| |_|  \\___| |_|    |_|  \\___|  \\__,_| |_| |_|\n" +
"                              __/ |                                                                                \n" +
"                             |___/                                                                                 ");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            System.out.println("****************************************************************************************************************************");
            
        }
        catch (ExcepcionPersonaje e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
