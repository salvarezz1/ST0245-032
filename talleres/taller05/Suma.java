import java.util.*;
import java.util.concurrent.TimeUnit;
public class Suma {  
    public static void main(int[] arr){
        for(int i=0; i<360000000; i=i+18000000){
            long start = System.currentTimeMillis();
            suma(creadorArreglo(i));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    public static int[] creadorArreglo(int n){
        int[] arr=new int[n];
        for(int i=n; i>0; i--){
            int c=0;
            arr[c]=n;
            c++;  
        }
        return arr;
    }

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){  
        int sum = 0; //C1
        for(int i=0; i<array.length; i++){ //C2*n
            sum = sum + array[i]; //C3*n
        }
        return sum; //C4
    }
    //T(n) = C1 + C2*n + C3*n + C4
    
}