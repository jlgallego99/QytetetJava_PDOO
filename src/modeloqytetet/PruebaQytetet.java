/*
 * Programación y Diseño Orientado a Objetos - Práctica Qytetet
 * Clase PruebaQytetet (Función Main)
 * Autor: Jose Luis Gallego Peña
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaQytetet {
    
    public static Qytetet juego = Qytetet.getInstance();
    private static final Scanner input = new Scanner(System.in);
    
    // Devuelve un arraylist con las sorpresas cuyo valor es mayor que 0
    private static ArrayList<Sorpresa> SorpresasPositivas(){
        ArrayList<Sorpresa> sorpresas = new ArrayList();
        
        for (Sorpresa s : juego.getMazo())
            if (s.getValor() > 0)
                sorpresas.add(s);
        
        return sorpresas;
    }
    
    // Devuelve un arraylist con las sorpresas cuyo tipo es IRACASILLA
    private static ArrayList<Sorpresa> SorpresasIracasilla(){    
        ArrayList<Sorpresa> sorpresas = new ArrayList();
        
        for (Sorpresa s : juego.getMazo())
            if (s.getTipo() == TipoSorpresa.IRACASILLA)
                sorpresas.add(s);
        
        return sorpresas;    
    }
    
    // Devuelve un arraylist con las sorpresas cuyo tipo se especifica
    private static ArrayList<Sorpresa> SorpresasTipo(TipoSorpresa tipo){   
        ArrayList<Sorpresa> sorpresas = new ArrayList();
        
        for (Sorpresa s : juego.getMazo()){
        
            if (s.getTipo() == tipo)
                sorpresas.add(s);
        
        }
        
        return sorpresas;   
    }
    
    // Pide el nombre de los jugadores que van a jugar Qytetet
    private static ArrayList<String> getNombreJugadores(){
        ArrayList<String> jugadores = new ArrayList();
        
        System.out.println("¿Cuántos jugadores van a jugar? (4 máximo, 2 mínimo)");
        int n = input.nextInt();
        System.out.println("Introduzca los nombres de los " + n + " jugadores:");
        String s = input.nextLine();
        for (int i = 0 ; i < n ; i++){
            //s = input.nextLine();
            jugadores.add(s);
        }
            
        return jugadores;
    }
    
    public static void main(String[] args) {
        ArrayList<String> jugadores = getNombreJugadores();
        juego.inicializarJuego(jugadores);
        
        System.out.println("\nJugadores:");
        for (String s : jugadores)
            System.out.println(s); 
        
        /* Invocar cada uno de los métodos definidos anteriormente */
        
        System.out.println("\n Método 1: Arraylist con las sorpresas con "
        + "valor positivo \n");
        ArrayList<Sorpresa> s_positivas = SorpresasPositivas();
        for (Sorpresa s : s_positivas)
            System.out.println(s.toString());
        
        System.out.println("\n Método 2: Arraylist con las sorpresas de tipo "
        + "IRACASILLA \n");
        ArrayList<Sorpresa> s_iracasilla = SorpresasIracasilla();
        for (Sorpresa s : s_iracasilla)
            System.out.println(s.toString());
        
        System.out.println("\n Método 3: Arraylist con cada tipo de sorpresa \n");       
        for (TipoSorpresa t : TipoSorpresa.values()){
            for (Sorpresa s : SorpresasTipo(t)){ 
                System.out.println(s.toString());        
            }            
        }     
        
        System.out.println(juego.toString());
    }
}
