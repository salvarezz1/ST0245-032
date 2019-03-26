
/**
 * Write a description of class MiHashmap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiHashmap
{
    Contacto[] lista;
    public MiHashmap(){
    lista=new Contacto[10];
    }
    
    public void agregar(String nombre, int telefono){
    Contacto c1=new Contacto(nombre,telefono);
    int n=nombre.codePointAt(0);
    int posicion= n%10;
    lista[posicion]=c1;
    }
    
    public int buscar(String nombre){
    int n=nombre.codePointAt(0);
    int posicion= n%10;
    Contacto c1=lista[posicion];
    return c1.value;
    
    
    }
}