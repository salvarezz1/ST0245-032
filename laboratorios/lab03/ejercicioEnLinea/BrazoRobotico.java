
/**
 * Write a description of class BrazoRobotico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class BrazoRobotico
{
    //Punto 2.2
    static int aux[];
    static Stack <Integer> nums[];
    public BrazoRobotico(int n){
        this.nums = new Stack[n];
        for(int i=n; i>=0; i--){
            nums[i].push(i);
        }
    }

    public void devolver(int n){
        while(!nums[n].isEmpty()){
            devolver(nums[n].pop());
        }
        nums[n].push(n);
        aux[n] = n;
    }

    public void borrar(int n){
        while(nums[aux[n]].peek() != n){
            devolver(nums[aux[n]].pop());
        }
    }

    public void moveOnto(int a, int b){
        borrar(b);
        moveOver(a,b);
    }

    public void moveOver(int a, int b){
        borrar(a);
        nums[aux[b]].push(nums[aux[a]].pop());
        aux[a]=aux[b];
    }

    public void pileOnto(int a, int b){
        borrar(b);
        pileOver(a,b);
    }

    public void pileOver(int a, int b){
        Stack<Integer>m=new Stack<Integer>();
        while(nums[aux[a]].peek()!=a) {
            m.push(nums[aux[a]].pop());
        }
        m.push(nums[aux[a]].pop());
        while(!m.isEmpty()) {
            int y = m.pop();
            nums[aux[b]].push(y);
            aux[y] = aux[b];
        }
    }

    public String quit(int n){
        String k = "";
        while(!nums[n].isEmpty()){
            k = " " + nums[n].pop() + k;
            k = n + ":" + k;
        }
        return k;
    }

    public void instrucciones(String x){
        String[] inst = x.split(" ");
        String f1 = inst[0];
        String f2 = inst[2];
        int a=Integer.parseInt(inst[1]);
        int b=Integer.parseInt(inst[3]);
        if(inst[1] != inst[3]){
            if(f1.equalsIgnoreCase("move")){
                if(f2.equalsIgnoreCase("onto")){
                    moveOnto(a,b);
                }
                else if(f2.equalsIgnoreCase("over")){
                    moveOver(a,b);
                }
            }
            else if(f1.equalsIgnoreCase("pile")){
                if(f2.equalsIgnoreCase("onto")){
                    pileOnto(a,b);
                }
                else if(f2.equalsIgnoreCase("over")){
                    pileOver(a,b);
                }
            }
            else if(f1.equalsIgnoreCase("quit")){
                for(int i=0; i<nums.length; i++){
                    System.out.println(quit(i));
                }
            }
            else{
                instrucciones(x);
            }
        }
        else{
            instrucciones(x);
        }
    }
}
