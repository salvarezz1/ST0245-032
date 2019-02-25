
/**
 * Write a description of class Contenedores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Contenedores
{

  /**
  * Realiza el calculo de las formas en las cuales se pueden ubicar
  * los rectangulos 1x2 en otro 2xn ademas dibuja cada una de ellas
  * @param n es el largo del rectangulo que se debe de utilizar para calcular el numero de formas
  *           de ubicar el rectangulo 1x2
  * @return int retorna un entero que representa las formas en las que se puede llenar el rectangulo 2xn
  */
  public static int nRectangulos(int n)
  {
      if(n<=2){//c1
        return n;//c2
        }
      return nRectangulos(n-1)+nRectangulos(n-2);//T(n)=t(n-1)+t(n-2)+c1
  }

  /**
  * Metodo principal, el cual ejecuta el programa e imprime el resultado
  * @param args un array de argumentos
  */
  public static void main(String[] args)
  {
    int pruebas [] ={4,5,7,3,2,8,9};
    for(int i = 0; i < pruebas.length; i++)
    {
      System.out.println(nRectangulos(i));
    }
  }
  
  public static void tiempos(String[]args ){
    for(int i=31; i<=50; i++){
            long start = System.currentTimeMillis();
            nRectangulos(i);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
    
}
