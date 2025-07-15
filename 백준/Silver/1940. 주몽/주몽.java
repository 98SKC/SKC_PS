import java.util.*;
import java.io.*;


public class Main{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt(); 
        int su = sc.nextInt(); 
        
        int[] array = new int[num]; 
        int count = 0; 
        int start = 0; 
        int end =array.length-1; 
        int sum =0; 
        
        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt(); 
        }

        Arrays.sort(array);  
        
        while(start < end){ 
           
            sum = array[start] + array[end]; 
            
            if(sum < su){ 
                start++;
            }else if(sum==su){ 
                start++;
                end--;
                count++;
            }else{ 
                end--;
            }
            
        }
        
        System.out.println(count);
    }
}