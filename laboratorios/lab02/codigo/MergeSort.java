
/**
 * Write a description of class MergeSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MergeSort
{
    public static void main(int[] arr){
        for(int i=0; i<200000; i=i+10000){
            long start = System.currentTimeMillis();
            mergeSort(creadorArreglo(i));
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
    
    
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mitad = arr.length / 2;
        int[] l = new int[mitad];
        int[] r = new int[arr.length - mitad];

        for (int i = 0; i < mitad; i++) {
            l[i] = arr[i];
        }
        for (int i = mitad; i < arr.length; i++) {
            r[i - mitad] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r, mitad, arr.length - mitad);
        return arr;
    }

    private static void merge(
    int[] arr, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }

    }
    
    
}
