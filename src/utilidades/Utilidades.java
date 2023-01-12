
package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase dedicada a m�todos que ayuden al desarrollo de la tarea.
 * Ejemplo: un m�todo para leer por pantalla una cadena de caracteres.
 * 
 * @author Adri�n Arjona
 * @version 1.1 Enero 2023
 */
public class Utilidades {
    
    /* Francisco Adri�n Arjona Bravo
        UNIDAD 5: desarrollo de clases.
    */
    
     /**
     * M�todo que pide al usuario una cadena de caracteres pudiendo personalizar 
     * el mensaje de petici�n.
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
     * M�todo que pide al usuario un n�mero entero pudiendo personalizar el 
     * mensaje de petici�n.
     * 
     * @param msg String. Mensaje con el que se pide el n�mero al usuario.
     * @return int entero. Devuelve el n�mero introducido por el usuario.
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
                
                System.out.println("No has introducido un n�mero entero.");
            }
            catch (Exception e) {
                
                System.out.println("No has introducido un n�mero entero.");
            }
        } while (!validador);

     
        return entero ;
    }
    
     /**
     * M�todo que pide al usuario un n�mero corto pudiendo personalizar el 
     * mensaje de petici�n.
     * 
     * @param msg String. Mensaje con el que se pide el n�mero al usuario.
     * @return byte. Devuelve el n�mero introducido por el usuario.
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
                
                System.out.println("No has introducido un n�mero v�lido.");
            }
            catch (Exception e) {
                
                System.out.println("No has introducido un n�mero v�lido.");
            }
        } while (!validador);

     
        return numero ;
    }
}
