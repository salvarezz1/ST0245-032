
/**
 * Write a description of class n here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TecladoRoto{
    //Punto 2.1
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        int contador = 0;
        boolean start = false;
        for (int i=0;i<a.length();i++){
            if(a.charAt(i)=='['){
                start = true;
                contador = 0;
            } else if (a.charAt(i)==']'){
                start = false;
            }
            if(a.charAt(i)!='[' && a.charAt(i)!=']'){
                if(start){
                    texto.add(contador,a.charAt(i));
                    contador++;
                } else {
                    texto.add(a.charAt(i));
                }
            }
        } 
        for(int i=0; i<texto.size(); i++){
            System.out.print(texto.get(i));
        }
    }
}
