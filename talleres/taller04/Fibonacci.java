
/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit;
public class Fibonacci
{
    public static int fibonacci(int i){
    if(i<=1){
     return i ;
    }
    return fibonacci(i-1)+fibonacci(i-2);
}
public static void main(String[] args){
  for(int i = 18; i <= 38; i++){
         long start = System.currentTimeMillis();
         fibonacci(i);
         long tiempo =  System.currentTimeMillis() - start;
         System.out.println(tiempo);
    }
}
}
