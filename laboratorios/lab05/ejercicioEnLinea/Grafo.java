
/**
 * Write a description of class Grafo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
class Grafo{
    private int vertices; 
    private LinkedList<Integer> adyacencia[];
    Grafo(int v) {
        vertices=v;
        adyacencia = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adyacencia[i] = new LinkedList();
        }
    }

    public void agregarArista(int a, int b) {
        adyacencia[a].add(b);
        adyacencia[b].add(a);
    }

    public boolean color() {
        int respuesta[] = new int[vertices];
        Arrays.fill(respuesta, -1);
        respuesta[0] = 0;
        boolean temp[] = new boolean[vertices];
        Arrays.fill(temp, true);
        for (int i=1; i<vertices; i++) {
            Iterator<Integer> iterador = adyacencia[i].iterator();
            while(iterador.hasNext()) {
                int sig = iterador.next();
                if (respuesta[sig] != -1) {
                    temp[respuesta[sig]] = false;
                }
            }
            int k;
            for (k=0; k<vertices; k++) {
                if (temp[k]) {
                    break;
                }
            }
            respuesta[i] = k;
            if (k>=2) {
                System.out.println("NO BICOLOREABLE");
                return false;
            }
            Arrays.fill(temp, true);
        }
        System.out.println("BICOLOREABLE");
        return true;
    }
} 
