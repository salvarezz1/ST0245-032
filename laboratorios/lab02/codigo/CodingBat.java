
/**
 * Write a description of class CodingBat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBat
{

    public int[] shiftLeft(int[] nums) { 
        if(nums.length==0){
            return nums;
        }
        int aux=nums[0];
        for(int i=0; i<nums.length-1; i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = aux;
        return  nums;
    }

    public int[] notAlone(int[] nums, int val) {
        for(int i=0; i<nums.length-2; i++){
            if(nums[i+1] == val && nums[i+1] != nums[i] && nums[i+1] != nums[i+2]){
                if(nums[i]>nums[i+2]){
                    nums[i+1] = nums[i]; 
                }
                else{
                    nums[i+1] = nums[i+2];
                }
            }
        }
        return nums;
    }

    public boolean has77(int[] nums) { //O(n)
        for(int i=0; i<nums.length-1; i++){
            if((nums[i]==7&&nums[i+1]==7) || (i+2<nums.length&&nums[i]==7&&nums[i+2]==7)){
                return true;
            }
        }
        return false;
    }

    
    public int countEvens(int[] nums) {
        int cont=0;//c1
        for(int i=0;i<nums.length;i++){//n

            if(nums[i]%2==0){//c2
                cont++;//c3
            }
        }
        return cont;//c4
        //o(n)
    }

    public int sum13(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]==13){
                sum=sum;
                i++;
            }
            else{
                sum=sum+nums[i];
            }
        }
        return sum;
        //o(n)
    }

    public boolean linearIn(int[] outer, int[] inner) { 
        int cont=0;
        for(int i=0; i<inner.length; i++){
            for(int j=0; j<outer.length; j++){
                if(inner[i]==outer[j]){
                    cont++;
                    break;
                }
            }
        }
        if(cont == inner.length){
            return true;
        }
        return false;
    }

    public int countClumps(int[] nums) {
        int cont=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                cont++;
                for(int j=i+1; j<nums.length-2; j++){
                    if(nums[j] == nums[j+1]){
                        cont--;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return cont;
    }


    public int maxSpan(int[] nums) {
        int maxSpan=0;
        for(int i=0;i<nums.length;i++){//n
            int span=0;
            for(int j=nums.length-1;j>=0;j--){//n*n
                if(nums[i]==nums[j]){
                    span=j-i+1;
                    break;
                }
            }
            if(span>maxSpan){
                maxSpan=span;
            }
        }
        return maxSpan;
        //o(n^2)
    }

    public int[] seriesUp(int n) {
        int[]nums=new int[n*(n+1)/2];
        int cont=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                nums[cont]=j;
                cont++;
            }
        }
        return nums;
    }

    public int[] fix34(int[] nums) {

        for(int i=0;i<nums.length; i++){//n

            if(nums[i]==3){//c1

                for(int j=0;j<nums.length;j++){//n*n

                    if(nums[j]==4&&nums[j-1]!=3){
                        int temp=nums[i+1];
                        nums[i+1]=4;
                        nums[j]=temp;
                    }
                }
            }
        }
        return nums;

        //o(n^2)
    }

}
