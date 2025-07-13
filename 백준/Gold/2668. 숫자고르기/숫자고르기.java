import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static ArrayList<Integer> list;
    public static int[] num;
    public static boolean[] v;
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        num = new int[n + 1];
        v = new boolean[n + 1];
        list = new ArrayList<>();
        

        for(int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }


        for(int i = 1; i <= n; i++) {
            v[i] = true;
            dfs(i, i);
            v[i] = false;
        }
        
        Collections.sort(list); 
        
        System.out.println(list.size());
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        
        
    }    
    
    public static void dfs(int start, int target) {
        
        if(v[num[start]] == false) {
            v[num[start]] = true;
            dfs(num[start], target);
            v[num[start]] = false;
        }
        
        if(num[start] == target) list.add(target); //사이클 발생시 해당 숫자를 list에 담아준다.
    }
    
}
