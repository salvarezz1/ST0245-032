
/**
 * Write a description of class Universidad here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Universidad
{
    static ArrayList <Info> informacion =new ArrayList<Info>();

    public static void addInfo(String Semestre, String nombre, String curso, double nota){
        Info i1=new Info(Semestre,nombre,curso,nota);
        informacion.add(i1);
    }
}
