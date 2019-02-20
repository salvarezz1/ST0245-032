
/**
 * Write a description of class insertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.concurrent.TimeUnit;
public class InsertionSort
{
    public static void main(int[] arr){
        for(int i=0; i<200000; i=i+10000){
            long start = System.currentTimeMillis();
            insertionSort(creadorArreglo(i));
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
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){  
        int aux; //C1
        for(int i=0; i<array.length; i++){ //C2*n
            for(int j=i+1; j<array.length; j++){ //C3*n*(n-1)
                if(array[i] > array[j]){ //C4
                    aux = array[i]; //C5
                    array[i] = array[j]; //C6
                    array[j] = aux; //C7
                }
            }
        }
        return array; //C8
        //T(n) = C1 + n[C2 + C3(n-1)]
    }    
}
