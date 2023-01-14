
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
    
//    private static void crearPersonaje1(){ // CREA PRESONAJE 1
//        
//        String nombre ;
//        byte inteligencia ;
//        byte fuerza ;
//        
//        boolean validador = false ;
//        
//        
//        System.out.println("\n-- Vas a crear el personaje 1 --\n");
//        
//        nombre = Utilidades.leerString("?Cuál es su nombre?") ;
//        
//        inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
//            " y " + Personaje.MAX_INTELIGENCIA + "):") ;
//            
//        fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
//                " y " + Personaje.MAX_FUERZA + "):") ;
//        
//        try
//        {
//            Personaje personaje1 = new Personaje(nombre, inteligencia, fuerza) ;
//        }
//        catch (ExcepcionPersonaje e){
//            System.out.println(e.getMessage());
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//    }
//    
//    private static void crearPersonaje2(){ // CREA PERSONAJE 2 (puede que no haga falta)
//        
//        String nombre ;
//        byte inteligencia ;
//        byte fuerza ;
//        
//        boolean validador = false ;
//        
//        
//        System.out.println("\n-- Vas a crear el personaje 2 --\n");
//        
//        nombre = Utilidades.leerString("?Cuál es su nombre?") ;
//        
//        do 
//        {
//            inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
//            " y " + Personaje.MAX_INTELIGENCIA + "):") ;
//            
//            fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
//                    " y " + Personaje.MAX_FUERZA + "):") ;
//
//            try
//            {
//                Personaje personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
//                validador = true ;
//            }
//            catch (ExcepcionPersonaje e){
//                System.out.println(e.getMessage());
//            }
//            catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            
//        } while (validador);
//        
//    }
    
    public static void main(String[] args) { // MÉTODO MAIN

        try
        {
            String nombre = "";
            byte inteligencia = Personaje.MIN_INTELIGENCIA ;
            byte fuerza = Personaje.MAX_FUERZA ;

            int opcion ;
            boolean personaje1Creado = false ;
            boolean personaje2Creado = false ;

            Personaje personaje1 = new Personaje(nombre, inteligencia, fuerza) ;
            Personaje personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
            
            
            System.out.println("MENSAJE DE BIENVENIDA"); // ---------------------------- EDITAR ---------------------------
            
            mostrarMenu();
            
            opcion = Utilidades.leerEntero("\nSELECCIONA UNA OPCIÓN:\n") ;
            
            switch (opcion)
            {
                case 1: // Crear personaje 1
                    
                    if (!personaje1Creado) 
                    {
                        System.out.println("\n-- Vas a crear el personaje 1 --\n");
                    
                        nombre = Utilidades.leerString("?Cuál es su nombre?") ;
                        personaje1.setNombre(nombre);

                        inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
                        " y " + Personaje.MAX_INTELIGENCIA + "):") ;
                        personaje1.setInteligencia(inteligencia);

                        fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
                        " y " + Personaje.MAX_FUERZA + "):") ;
                        personaje1.setFuerza(fuerza);
                        
                        personaje1Creado = true ;
                    }
                    else
                    {
                        System.out.println("\nEl personaje 1 ya ha sido creado.\n");
                    }
                    
                    break;
                    
                case 2: // Crear personaje 2
                    
                    if (!personaje2Creado) 
                    {
                        System.out.println("\n-- Vas a crear el personaje 2 --\n");
                    
                        nombre = Utilidades.leerString("?Cuál es su nombre?") ;
                        personaje2.setNombre(nombre);

                        inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
                        " y " + Personaje.MAX_INTELIGENCIA + "):") ;
                        personaje2.setInteligencia(inteligencia);

                        fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
                        " y " + Personaje.MAX_FUERZA + "):") ;
                        personaje2.setFuerza(fuerza);

                        personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
                        
                        personaje2Creado = true ;
                    }
                    else
                    {
                        System.out.println("\nEl personaje 2 ya ha sido creado.\n");
                    }
                    
                    break;
                    
                case 3: // Batalla
                    
                case 4: // Mostrar personajes
                    
                    System.out.println(personaje1.toString());
                    System.out.println(personaje2.toString());
                    break ;
                    
                case 5: // Modificar personaje 1
                case 6: // Modificar personaje 2
                case 7: // Salir
                    
            }
        }
        catch (ExcepcionPersonaje e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
