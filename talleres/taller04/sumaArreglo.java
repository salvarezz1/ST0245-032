
import java.util.*;
import java.util.concurrent.TimeUnit;
/**
*La clase Taller5 dos tiene como objetivo dar solución al taller5
*
*@autor Mauricio Toro, Camilo Paez
*@version 1
*/
public class sumaArreglo {
    
  public static void main(String[] args){
  for(int i = 1; i <= 20; i++)
       suma(new int[i]);
}
// Operaciones que realiza T(n) = cn + c1
private static int suma(int[] a,int i){  
   try{
   TimeUnit.SECONDS.sleep(1);
}
catch (Exception e){
   
}
if (i == a.length) // C1
      return 0;  // C2
   else
      return a[i] + suma(a, i+1); // C3 + T(n-1) 
}
public static int suma(int[] a){
  long start = System.currentTimeMillis();
  int s = suma(a,0);
  long tiempo =  System.currentTimeMillis() - start;
  System.out.println(tiempo);
  return s;
}
 }