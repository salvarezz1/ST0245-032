
/**
 * Write a description of class u here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nevera {
    int codigo;
    String descripcion;
    
    public Nevera(int codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}