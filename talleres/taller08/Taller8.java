
/**
 * Write a description of class taller08 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
public class Taller8 {

    
    /**
     * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
     * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
     * Se intenta hacer el calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
    public  static void polaca (String string){
        String[] arr = string.split(" ");    
        Stack < String > a = new Stack < String > (); 
        Stack < String > b = new Stack < String > ();
        String signos = "+-*/%"; 

        for (int i = arr.length - 1; i >= 0; i--) {
            a.push(arr[i]);
        }

        while (!(a.isEmpty())) {
            if (signos.contains(a.peek())) {
                b.push(evaluar(a.pop(), b.pop(), b.pop()) + "");
            }else {
                b.push(a.pop());
            } 
        }
        System.out.println("Resultado: " + b.peek());

    }

    private static int evaluar(String signo, String segundo, String primero) {
        int n1 = Integer.parseInt(primero);
        int n2 = Integer.parseInt(segundo);
        if (signo.equals("-")){
            return (n1 - n2);
        }
        
       if (signo.equals("/")){
        return (n1 / n2);
        } 
        
        if (signo.equals("*")) {
        return (n1 * n2);
        }
        if (signo.equals("+")){
        return (n1 + n2);
        } 
        
        if (signo.equals("%")) {
        return (n1 % n2);
        }
        return 0;
    }
}

