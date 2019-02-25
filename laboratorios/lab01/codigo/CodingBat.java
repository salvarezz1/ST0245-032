
/**
 * Write a description of class CodingBat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBat
{

    public int factorial(int n) {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public int sumDigits(int n) {
        if(n==0){
            return 0;
        }
        else{
            int u=n%10;
            int nu=n/10;
            return u+sumDigits(nu);
            
        }
    }

    public int powerN(int base, int n) {
        if(n==0){
            return 1;
        }
        return base*powerN(base, n-1);
    }

    public int fibonacci(int n) {
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public boolean array6(int[] nums, int index) {
        if(index==nums.length){
            return false;
        }
        else if(nums[index]==6){
            return true;
        }
        else 
            return array6(nums,index+1);
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start==nums.length){
            return target==0;
        }  
        if(nums[start]==6){
            return groupSum6(start+1,nums,target-6);
        }
        else{
            return groupSum6(start+1,nums,target)|| groupSum6(start+1,nums,target-nums[start]);
        }
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if(start==nums.length){
            return target==0;
        }  
        if(start+1<nums.length&&nums[start]%5==0){
            if( nums[start+1]!=1)
                return groupSum5(start+1,nums,target-nums[start]);
            else{
                return groupSum5(start+2,nums,target-nums[start]);
            }
        }
        else{
            return groupSum5(start+1,nums,target)|| groupSum5(start+1,nums,target-nums[start]); 
        }
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start==nums.length){
            return target==0;
        }  
        if(start+1<nums.length&&nums[start]==nums[start+1]){
            return groupSumClump(start+2,nums,target-2*nums[start])||groupSumClump(start+2,nums,target);
        }
        else{
            return groupSumClump(start+1,nums,target)|| groupSumClump(start+1,nums,target-nums[start]);
        }

    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length){
            return target==0;
        }  

        else{
            return groupNoAdj(start+1,nums,target)|| groupNoAdj(start+2,nums,target-nums[start]);
        }

    }

    
    
    public boolean splitArray(int[] nums) {
        int i=0;
        int s1=0;
        int s2=0;
        return helper(nums,i,s1,s2);  
    }
    public boolean helper(int[] nums, int i, int s1,int s2){
        if(i==nums.length){
            if(s1==s2){
                return true;
            }
            else{
                return false;
            }
        }
        else return helper(nums,i+1,s1+nums[i],s2)|| helper(nums,i+1,s1,s2+nums[i]);
    }

}
