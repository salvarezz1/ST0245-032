
/**
 * Esta clase permite leer datos, guardalos como abejas y detectar colisiones entre abejas 
 * @author (Mariajose Franco, Susana Alvarez)
 * @version (Abril 6, 2019)
 */
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.lang.Runtime;
import java.lang.Long;
public class Datos
{
    public static ArrayList <Abeja>abejas=new ArrayList<Abeja>();
    /**
     * Este método permite ver cuanto se demora el programa leyendo, guardando los datos y detectando colisiones de diferentes archivos y cuanta memoria se consume
     * @param String[] args
     */
    public void main(String[]args){
        //tiemposYMemoriaLeerDatos("4abejas.txt");
        //tiemposYMemoriaDetectarColisiones("4abejas.txt");
        //tiemposYMemoriaLeerDatos("15abejas.txt");
        //tiemposYMemoriaDetectarColisiones("15abejas.txt");
        //tiemposYMemoriaLeerDatos("150abejas.txt");
        //tiemposYMemoriaDetectarColisiones("150abejas.txt");
        //tiemposYMemoriaLeerDatos("1,500abejas.txt");
        //tiemposYMemoriaDetectarColisiones("1,500abejas.txt");
        //tiemposYMemoriaLeerDatos("15,000abejas.txt");
        //tiemposYMemoriaDetectarColisiones("15,000abejas.txt");
        //tiemposYMemoriaLeerDatos("150,000abejas.txt");
        //tiemposYMemoriaDetectarColisiones("150,000abejas.txt");
        //tiemposYMemoriaLeerDatos("1,500,000abejas.txt");
       //tiemposYMemoriaDetectarColisiones("1,500,000abejas.txt");

    }

    /**
     * Este método permite ver cuanto se demora el programa leyendo y guardando los datos de un archivo y cuanta memoria se consume
     * @param String Archivo
     */
    private void tiemposYMemoriaLeerDatos(String Archivo){
        long minTiempo=Long.MAX_VALUE;
        long maxTiempo=Long.MIN_VALUE;
        long minMemoria=Long.MAX_VALUE;
        long maxMemoria=Long.MIN_VALUE;;
        long sumaTiempos=0;
        long sumaMemoria=0;
        for(int i=1; i<=100;i++){
            System.gc();
            long startLectura = System.currentTimeMillis();
            leerYGuardarDatos(Archivo);
            long endLectura = System.currentTimeMillis();
            long tiempoFinal=endLectura-startLectura;
            sumaTiempos=sumaTiempos+tiempoFinal;
            Runtime m=Runtime.getRuntime();
            long memoriaUsada=(m.totalMemory()-m.freeMemory());
            sumaMemoria=memoriaUsada+sumaMemoria;
            if(tiempoFinal<minTiempo){
                minTiempo=tiempoFinal;
            }
            if(tiempoFinal>maxTiempo){
                maxTiempo=tiempoFinal;
            }
            if(memoriaUsada<minMemoria){
                minMemoria=memoriaUsada;
            }
            if(memoriaUsada>maxMemoria){
                maxMemoria=memoriaUsada;
            }
        }
        long tiempoPromedio=sumaTiempos/100;
        long memoriaPromedio=sumaMemoria/100;
        System.out.println("tiempo promedio en guardar datos:"+ (tiempoPromedio+" milisegundos"));
        System.out.println("tiempo máximo en guardar datos:"+ (maxTiempo+" milisegundos"));
        System.out.println("tiempo mínimo en guardar datos:"+ (minTiempo+" milisegundos"));
        System.out.println("promedio de memoria gastada en guardar datos:"+memoriaPromedio+" bytes");
        System.out.println("máxima memoria gastada en guardar datos:"+maxMemoria+" bytes"); 
        System.out.println("mínima memoria gastada en guardar datos:"+minMemoria+" bytes");
    }

    /**
     * Este método permite ver cuanto se demora el programa encontrando las colisiones entre las abejas y cuanta memoria se consume
     * @param String archivo
     */
    private void tiemposYMemoriaDetectarColisiones(String Archivo){
        long minTiempo=Long.MAX_VALUE;
        long maxTiempo=Long.MIN_VALUE;
        long minMemoria=Long.MAX_VALUE;
        long maxMemoria=Long.MIN_VALUE;;
        long sumaTiempos=0;
        long sumaMemoria=0;
        for(int i=1; i<=100;i++){
            leerYGuardarDatos(Archivo);
            System.gc();
            long startLectura = System.currentTimeMillis();
            detectarColisiones();
            long endLectura = System.currentTimeMillis();
            long tiempoFinal=endLectura-startLectura;
            sumaTiempos=sumaTiempos+tiempoFinal;
            Runtime m=Runtime.getRuntime();
            long memoriaUsada=(m.totalMemory()-m.freeMemory());
            sumaMemoria=memoriaUsada+sumaMemoria;
            if(tiempoFinal<minTiempo){
                minTiempo=tiempoFinal;
            }
            if(tiempoFinal>maxTiempo){
                maxTiempo=tiempoFinal;
            }
            if(memoriaUsada<minMemoria){
                minMemoria=memoriaUsada;
            }
            if(memoriaUsada>maxMemoria){
                maxMemoria=memoriaUsada;
            }
        }
        long tiempoPromedio=sumaTiempos/100;
        long memoriaPromedio=sumaMemoria/100;
        System.out.println("tiempo promedio en detectar colisiones:"+ (tiempoPromedio+" milisegundos"));
        System.out.println("tiempo máximo en detectar colisiones:"+ (maxTiempo+" milisegundos"));
        System.out.println("tiempo mínimo en detectar colisiones:"+ (minTiempo+" milisegundos"));
        System.out.println("promedio de memoria gastada en detectar colisiones:"+memoriaPromedio+" bytes");
        System.out.println("máxima memoria gastada en detectar colisiones:"+maxMemoria+" bytes"); 
        System.out.println("mínima memoria gastada en detectar colisiones:"+minMemoria+" bytes");
    }

    /**
     * Este método lee un archivo con datos y los guarda en un arraylist de objetos tipo abeja
     * @param String nombreArchivo
     */
    public void leerYGuardarDatos(String nombreArchivo){
        try{

            BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
            String linea=br.readLine();
            linea=br.readLine();

            while(linea!=null){
                String[]cadena=linea.split(",");
                double x=Double.parseDouble(cadena[0]);
                double y=Double.parseDouble(cadena[1]);
                double z=Double.parseDouble(cadena[2]);
                Abeja a=new Abeja(x,y,z);
                abejas.add(a);
                linea=br.readLine();
            }
        }
        catch(IOException ioe){
            System.out.println("el archivo no existe");
        }

    }

    /**
     * Este método permite detectar colisiones entre las abejas que se agregaron al arraylist de abejas cuando se leyeron los datos
     */
    public void detectarColisiones(){
        double Xmax=abejas.get(0).x;double Xmin=abejas.get(0).x;
        double Ymax=abejas.get(0).y;double Ymin=abejas.get(0).y;
        double Zmax=abejas.get(0).z;double Zmin=abejas.get(0).z;   
        for(int i=0;i<abejas.size();i++){
            double x=abejas.get(i).x;
            double y=abejas.get(i).y;
            double z=abejas.get(i).z;

            if(x>Xmax){
                Xmax=x;
            }
            if(y>Ymax){
                Ymax=y;
            }
            if(z>Zmax){
                Zmax=z; 
            }
            if(x<Xmin){
                Xmin=x;
            }
            if(y<Ymin){
                Ymin=y;
            }
            if(z<Zmin){
                Zmin=z;
            }     
        }
        Octante principal=new Octante(Xmax,Xmin,Ymax,Ymin,Zmax,Zmin);
        principal.a=abejas;
        principal.padre=null;

        separacionOctantes(principal);
    }

    /**
     * Este método permite separar un octante en otros 8 octantes hasta encontrar las abejas que van a colisionar
     * @param Octante o
     */
    private void separacionOctantes(Octante o){
        double maxX=o.Xmax;double minX=o.Xmin;
        double maxY=o.Ymax;double minY=o.Ymin;
        double maxZ=o.Zmax;double minZ=o.Zmin;

        double Xmitad=Math.abs(maxX-minX)/2+minX;
        double Ymitad=Math.abs(maxY-minY)/2+minY;
        double Zmitad=Math.abs(maxZ-minZ)/2+minZ;
        boolean entro=false;

        if(Math.sqrt((maxX-minX)*(maxX-minX)+(maxY-minY)*(maxY-minY)+(maxZ-minZ)*(maxZ-minZ))<=100&&entro==false||o.a.size()<=1){
            if(o.a.size()>=2){
                for(int j=0; j<o.a.size();j++){
                    Abeja a=o.a.get(j);
                    System.out.println("La abeja con coordenadas "+a.x+","+a.y+","+a.z+" esta en riesgo de colision");

                }

            }
            else if(o.a.size()==1){
                Abeja a1= o.a.get(0);
                if(o.padre!=null){
                    for(int i=0; i<o.padre.a.size(); i++){
                        Abeja a2=o.padre.a.get(i);
                        if(Math.sqrt((a1.x-a2.x)*(a1.x-a2.x)+(a1.y-a2.y)*(a1.y-a2.y)+(a1.z-a2.z)*(a1.z-a2.z))<=100&&Math.sqrt((a1.x-a2.x)*(a1.x-a2.x)+(a1.y-a2.y)*(a1.y-a2.y)+(a1.z-a2.z)*(a1.z-a2.z))!=0){
                            System.out.println("La abeja con coordenadas "+a1.x+","+a1.y+","+a1.z+" esta en riesgo de colision");
                            break;
                        }

                    }

                }

            }
            else{

            }
            entro=true;
        }

        else{
            Octante s1=new Octante(maxX,Xmitad,maxY,Ymitad, maxZ,Zmitad);//+,+,+
            Octante s2=new Octante(Xmitad,minX,maxY,Ymitad, maxZ,Zmitad);//-,+,+
            Octante s3=new Octante(Xmitad,minX,Ymitad,minY, maxZ,Zmitad);//-,-,+
            Octante s4=new Octante(maxX,Xmitad,Ymitad,minY, maxZ,Zmitad);//+,-,+
            Octante s5=new Octante(maxX,Xmitad,maxY,Ymitad, Zmitad,minZ);//+,+,-
            Octante s6=new Octante(Xmitad,minX,maxY,Ymitad, Zmitad,minZ);//-,+,-
            Octante s7=new Octante(Xmitad,minX,Ymitad,minY, Zmitad,minZ);//-,-,-
            Octante s8=new Octante(maxX,Xmitad,Ymitad,minY, Zmitad,minZ);//+,-,-
            s1.padre=o;s2.padre=o;s3.padre=o;s4.padre=o;s5.padre=o;s6.padre=o;s7.padre=o;s8.padre=o;

            for(int i=0; i<o.a.size();i++){
                Abeja a1= o.a.get(i);
                double x=a1.x;
                double y=a1.y;
                double z=a1.z;
                if(x>Xmitad&& y>Ymitad &&z>Zmitad){
                    s1.a.add(a1);
                }
                if(x<Xmitad&& y>Ymitad &&z>Zmitad){
                    s2.a.add(a1);
                }
                if(x<Xmitad&& y<Ymitad &&z>Zmitad){
                    s3.a.add(a1);
                }
                if(x>Xmitad&& y<Ymitad &&z>Zmitad){
                    s4.a.add(a1);
                }
                if(x>Xmitad&& y>Ymitad &&z<Zmitad){
                    s5.a.add(a1);
                }
                if(x<Xmitad&& y>Ymitad &&z<Zmitad){
                    s6.a.add(a1);
                }
                if(x<Xmitad&& y<Ymitad &&z<Zmitad){
                    s7.a.add(a1);
                }
                if(x>Xmitad&& y<Ymitad &&z<Zmitad){
                    s8.a.add(a1);
                }
            }
            separacionOctantes(s1);
            separacionOctantes(s2);
            separacionOctantes(s3);
            separacionOctantes(s4);
            separacionOctantes(s5);
            separacionOctantes(s6);
            separacionOctantes(s7);
            separacionOctantes(s8);

        }
    }
}

