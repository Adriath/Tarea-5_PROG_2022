
package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase dedicada a métodos que ayuden al desarrollo de la tarea.
 * Ejemplo: un método para leer por pantalla una cadena de caracteres.
 * 
 * @author Adrián Arjona
 * @version 1.1 Enero 2023
 */
public class Utilidades {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
     /**
     * Método que pide al usuario una cadena de caracteres pudiendo personalizar 
     * el mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide la cadena al usuario.
     * @return String mensaje. Devuelve la cadena introducida por el usuario.
     */
    public static String leerString(String msg){
    
        Scanner entrada = new Scanner(System.in) ;
        
        System.out.println(msg);
        String mensaje = entrada.nextLine() ;
        
        return mensaje ;
    }
    
     /**
     * Método que pide al usuario un número entero pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return int entero. Devuelve el número introducido por el usuario.
     */
    public static int leerEntero(String msg){
        
        int entero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                entero = Integer.parseInt(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("No has introducido un número entero.");
            }
            catch (Exception e) {
                
                System.out.println("No has introducido un número entero.");
            }
        } while (!validador);

     
        return entero ;
    }
    
     /**
     * Método que pide al usuario un número corto pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return byte. Devuelve el número introducido por el usuario.
     */
    public static byte leerByte(String msg){
        
        byte numero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                numero = Byte.parseByte(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("No has introducido un número válido.");
            }
            catch (Exception e) {
                
                System.out.println("No has introducido un número válido.");
            }
        } while (!validador);

     
        return numero ;
    }
}
