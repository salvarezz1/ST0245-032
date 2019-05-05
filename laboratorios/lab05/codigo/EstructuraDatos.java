
/**
 * Write a description of class EstructuraDatos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class EstructuraDatos
{
    ArrayList<Vertice>infoVertices=new ArrayList<Vertice>();
    ArrayList<Arco>arcos=new ArrayList<Arco>();
    public EstructuraDatos(ArrayList<Vertice> v,ArrayList<Arco> D){
        arcos=D;
        infoVertices=v;

    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public  ArrayList<Long> getSuccessors(long vertexID){
        ArrayList<Long> sucesores=new ArrayList<Long>();
        for(int i=0; i<arcos.size(); i++){
            long codigo=arcos.get(i).codigo1;
            if(vertexID==codigo){
                sucesores.add(arcos.get(i).codigo2);
            }
        }
        return sucesores;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */ 
    public double getWeight(int sourceID, int destinationID){
        for(int i=0; i<arcos.size(); i++){
            if(sourceID==arcos.get(i).codigo1&&destinationID==arcos.get(i).codigo2){
                return arcos.get(i).distancia;

            }

        }
        return 0;
    }

    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int size() {
        return infoVertices.size();
    }
}
