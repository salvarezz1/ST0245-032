/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.  
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
 * @author Mauricio Toro, Andres Paez
 *
 */

public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    
    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        if(root==null){
            Node r=new Node(n);
            root=r;
        }
        else{
            insertarAux(root, n);
        }

    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private Node insertarAux(Node node, int n) {
        if(node==null){
            Node k=new Node(n);
        }
        else{
            if(n>node.data){
                node.right = insertarAux(node.right, n);
            }
            else if(n<node.data){
                node.left = insertarAux(node.left, n);
            }
            else{
                return node;
            }
        }
        return node;
    }

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n){
        if(node==null){
            return false;
        }
        else{
            if(n==node.data){
                return true;
            }
            if(n<node.data){
                return buscarAux(node.left, n);
            }
            if(n>node.data){
                return buscarAux(node.right, n);
            }
        }
        return false;
    }

}