
import java.util.Scanner;

public class ArbolBinario {

    public Nodo raiz;
    private Nodo addAux(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }

        if (dato < actual.dato) {
            actual.izq = addAux(actual.izq, dato);
        } else if (dato > actual.dato) {
            actual.der = addAux(actual.der, dato);
        } else {
            return actual;
        }

        return actual;
    }

    public void add(int dato) {
        raiz = addAux(raiz, dato);
    }

    public void preOrden(Nodo nodo){
        if(nodo != null){
            System.out.println(nodo.dato);
            preOrden(nodo.izq);
            preOrden(nodo.der);
        }
    }

    public void posOrden(Nodo nodo){
        if(nodo != null){
            posOrden(nodo.izq);
            posOrden(nodo.der);
            System.out.println(nodo.dato);
        }
    }

    public static void main(String[] args) {
        ArbolBinario b = new ArbolBinario();
        Scanner sc = new Scanner(System.in);
        int dato = sc.nextInt();
        while(dato != -1){
            b.add(dato);
            dato = sc.nextInt();
        }
        System.out.println();
        b.posOrden(b.raiz);
    }

}