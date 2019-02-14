
/**
 * Write a description of class GroupSum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit;
public class GroupSum
{
  public static void main(String[] args){
       for(int i = 1; i <= 20; i++){
          groupSum(new int[i]);
       }
   }

    private static boolean groupSum(int start, int[] nums, int target) {
        if(nums.length==start){ //C1
            return target==0; //C2
        }
        else{
            return groupSum(start+1, nums, target) || groupSum(start+1, nums, target-nums[start]); // T(n-1) + T(n-1)
        }
    }
   public static boolean groupSum(int[] a){
       int t=(int)Math.random()*100+30;
       long start= System.currentTimeMillis();
       boolean s=groupSum(0,a,t);
       long tiempo=System.currentTimeMillis()-start;
       System.out.println(tiempo);
       return s;
    }
  
}
