
/**
 * Write a description of class u here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud {
    String tienda;
    int cantidad;
    
    public Solicitud(String tienda, int cantidad){
        this.tienda = tienda;
        this.cantidad = cantidad;
    }
    
    public String getTienda(){
        return tienda;
    }
    
    public int getCantidad(){
        return cantidad;
    }
}
