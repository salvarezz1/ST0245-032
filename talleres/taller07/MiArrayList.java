
import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;
public class MiArrayList {

    private Node first;
    private int size;

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        first = null;

    }     

    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (size==0||(index >= 0 && index < size)) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.siguiente;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }   

    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.valor;
    }

    public void insert(int valor, int index){
        Node n=getNode(index-1);
        Node nuevo= new Node(valor);
        if(size==0){
            first=nuevo;
        }
        else if(n.siguiente!=null){
            Node aux=n.siguiente;
            n.siguiente=nuevo;
            nuevo.siguiente=aux;
        }
        else{
            n.siguiente=nuevo;
        }
        size++;
        //complejidad= O(n)
        //este algoritmo no es útil para un editor de texto, ya que un editor de texto necesita que el
        // metodo agregar sea demasiado rapido, y aunque este algoritmo tenga complejidad de o(n), 
        //lo cual muestra que no se demora tanto ejecutando, el algoritmo no es lo suficientemente rapido. 
    }

    public void remove(int index)
    {
        if (index == 0){
            first = first.siguiente;
        }
        else{
            Node anterior = getNode(index-1);
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        size--;
    }

    public boolean contains(int valor){
        Node temp= first;
        for(int i=0;i<size;i++){
            if(valor==temp.valor){
                return true;
            }
            temp=temp.siguiente;

        }

        return false;
    }
}