
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
        
        String nombre ;
        byte inteligencia ;
        byte fuerza ;
        
        boolean validador = false ;        
        int opcion ;
        
        try
        {
            System.out.println("MENSAJE DE BIENVENIDA"); // ---------------------------- EDITAR ---------------------------
            
            mostrarMenu();
            
            opcion = Utilidades.leerEntero("\nSELECCIONA UNA OPCIÓN:\n") ;
            
            switch (opcion)
            {
                case 1: // Crear personaje 1
                    
                    System.out.println("\n-- Vas a crear el personaje 1 --\n");
                    
                    nombre = Utilidades.leerString("?Cuál es su nombre?") ;
                    
                    inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
                    " y " + Personaje.MAX_INTELIGENCIA + "):") ;
                    
                    fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
                    " y " + Personaje.MAX_FUERZA + "):") ;
                    
                    Personaje personaje1 = new Personaje(nombre, inteligencia, fuerza) ;
                    
                    break;
                    
                case 2: // Crear personaje 2
                    
                    System.out.println("\n-- Vas a crear el personaje 2 --\n");
                    
                    nombre = Utilidades.leerString("?Cuál es su nombre?") ;
                    
                    inteligencia = Utilidades.leerByte("Define su inteligencia (puntos entre " + Personaje.MIN_INTELIGENCIA + 
                    " y " + Personaje.MAX_INTELIGENCIA + "):") ;
                    
                    fuerza = Utilidades.leerByte("Define ahora su fuerza (puntos entre " + Personaje.MIN_FUERZA + 
                    " y " + Personaje.MAX_FUERZA + "):") ;
                    
                    Personaje personaje2 = new Personaje(nombre, inteligencia, fuerza) ;
                    
                    break;
                    
                case 3: // Batalla
                    
                case 4: // Mostrar personajes
                    
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
