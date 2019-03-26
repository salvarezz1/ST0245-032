
/**
 * Write a description of class Punto2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Punto2


{
    HashMap<String, String> map1=new HashMap<String, String>();
    public void pedrito(){
    
    map1.put("Google","Estados Unidos");
    map1.put("La locura","Colombia");
    map1.put("Nokia","Finlandia");
    map1.put("Sony","Japón");
    
    }
    
    public void agregar(String empresa, String pais){
    map1.put(empresa,pais);
    System.out.print("el pais "+pais+" fue asociado a la empresa "+empresa);
    }
    public void buscar(String empresa){
    String pais=map1.get(empresa);
    System.out.print("el pais asociado a "+empresa+" es: "+pais);
    }
}
