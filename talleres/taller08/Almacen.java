
/**
 * Write a description of class u here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Almacen {
   LinkedList<Nevera>neveras = new LinkedList<>();
   LinkedList<Solicitud>solicitudes = new LinkedList<>();
   
   public void agregarNevera(Nevera nevera){
       neveras.add(nevera);
   }
   
   public void agregarSolicitud(Solicitud solicitud){
       solicitudes.add(solicitud);
   }
   
   public void entregasAlmacen(){
       int pendientes = solicitudes.size();
       for(int i=0;i<pendientes;i++){
           Solicitud solicitud = solicitudes.remove();
           int cantidad = solicitud.getCantidad();
           System.out.println(solicitud.getTienda()+" : ");
           while(cantidad != 0 && neveras.size() != 0){
               Nevera temp = neveras.pop();
               System.out.println(" "+temp.getCodigo()+"-"+temp.getDescripcion());
               cantidad--;
           }
           System.out.println();
       }
   }
}