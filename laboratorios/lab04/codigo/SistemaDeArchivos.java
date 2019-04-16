
/**
 * Write a description of class LectorDeDatos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class SistemaDeArchivos
{
    ArrayList<ArrayList<String>> a1= new ArrayList<ArrayList<String>>();
    Directorio d1;
    public void main(String args[]){//ensayos
        leerYGuardarDatos("ejemplo.txt");
        buscarEnDirectorio("abstractions");

    }

    public void leerYGuardarDatos(String nombreArchivo){
        try{

            BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
            String nombreDirectorio=br.readLine();
            d1=new Directorio(nombreDirectorio);
            String linea=br.readLine();

            while(linea!=null){
                ArrayList<String>cd=new ArrayList<String>();
                String[]cadena=linea.split(" ");
                for(int i=0; i<cadena.length;i++){
                    cd.add(cadena[i]);
                }
                a1.add(cd);
                linea=br.readLine();
            }
            identificacionNivel();

        }
        catch(IOException ioe){
            System.out.println("el archivo no existe");
        }
    }

    private void identificacionNivel(){
        for(int i=0; i<a1.size(); i++){
            ArrayList<String>s1=a1.get(i);
            int cont=0;
            for(int j=0; j<s1.size();j++){
                String info=s1.get(j);
                if(info.length()==0){
                    s1.remove(j);
                    j--;
                }
                if(info.contains("├")||info.contains("└")||info.contains("│")){
                    cont++;
                    s1.remove(info);
                    j--;
                }

            }
            s1.add(""+cont);
            s1.trimToSize();
        }
        a1.trimToSize();
        guardarcomoDirectorio(a1);
    }

    private void guardarcomoDirectorio(ArrayList<ArrayList<String>> a1){
        for(int i=0;i<a1.size();i++){
            ArrayList <String>s=a1.get(i);
            String usuario=s.get(0).substring(1);
            String memoria=s.get(1).substring(0,s.get(1).length()-1);
            String nombre="";
            String grado=s.get(s.size()-1);
            for(int j=2;j<s.size()-1;j++){
                nombre=nombre+" "+s.get(j); 
            }
            ArchivoOCarpeta q= new ArchivoOCarpeta(usuario,memoria,nombre,grado);
            d1.info.add(q);
        }
    }

    public void buscarEnDirectorio(String nombreDirectorio){
        boolean encontro=false;
        for(int i=0; i<d1.info.size();i++){
            if(d1.info.get(i).nombre.contains(nombreDirectorio)){
                encontro=true;
                int k=Integer.parseInt(d1.info.get(i).grado);
                for(int j=i+1;j<d1.info.size();j++){
                    ArchivoOCarpeta o=d1.info.get(j);
                    if(k<Integer.parseInt(o.grado)){
                        for(int m=1; m<=Integer.parseInt(o.grado);m++){
                            System.out.print(" ");
                        }
                        System.out.println("["+o.usuario+" "+o.tamaño+"] "+o.nombre);
                    }

                    else{
                        break;
                    }

                }
            }

        }
        if(encontro==false){
            System.out.println("No such file or directory");
        }
    }
}

