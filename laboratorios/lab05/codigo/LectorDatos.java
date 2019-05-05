
/**
 * Write a description of class LectorDatos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.Object;
import java.util.*;
public class LectorDatos
{
    ArrayList<Vertice>infoVertices=new ArrayList<Vertice>();
    ArrayList<Arco>arcos=new ArrayList<Arco>();
    EstructuraDatos e1;
    /**
     * Este método lee un archivo con datos y los guarda en un arraylist de objetos tipo abeja
     * @param String nombreArchivo
     */

    public void leerYGuardarDatos(String nombreArchivo){

        try{
            int numVertices=0;
            BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
            String linea=br.readLine();
            linea=br.readLine();
            boolean arco=false;
            int numMasGrande=0;

            while(linea!=null){
                if(linea.equals("")){
                    linea=br.readLine();
                }
                else if(!(linea.contains("Arcos."))&&!arco){
                    String[]cadena=linea.split(" ");
                    Long id=Long.parseLong(cadena[0]);
                    double x=Double.parseDouble(cadena[1]);
                    double y=Double.parseDouble(cadena[2]);
                    String nombre;
                    if(cadena.length>3){
                        nombre=cadena[3];
                    }
                    else{
                        nombre=" ";
                    }
                    Vertice v=new Vertice(id,x,y,nombre);
                    numVertices++;
                    infoVertices.add(v);
                    linea=br.readLine();
                }

                else if(linea.contains("Arcos.")){
                    linea=br.readLine();
                    arco=true;
                }
                else{
                    String[]cadena=linea.split(" ");
                    Long c1=Long.parseLong(cadena[0]);
                    Long c2=Long.parseLong(cadena[1]);
                    double distancia=Double.parseDouble(cadena[2]);
                    String nombre;
                    if(cadena.length>3){
                        nombre=cadena[3];
                    }
                    else{
                        nombre=" ";
                    }

                    Arco a1= new Arco(c1,c2,distancia,nombre);
                    arcos.add(a1);
                    linea=br.readLine();
                }              
            }
            e1= new EstructuraDatos(infoVertices,arcos);
        }
        catch(IOException ioe){
            System.out.println("el archivo no existe");
        }

    }

    public ArrayList<Long> main(){
        leerYGuardarDatos("medellin.txt");
        return e1.getSuccessors(330553021);
    }
}

