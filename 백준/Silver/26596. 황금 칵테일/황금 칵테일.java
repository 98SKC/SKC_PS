

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        String[] str;
        HashMap<String,Integer> map=new HashMap<>();
        for(int t=0;t<T;t++) {
            str=br.readLine().split(" ");
            map.put(str[0], map.getOrDefault(str[0],0)+Integer.parseInt(str[1]));
        }

      
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int v:map.values()){
            freq.put(v, freq.getOrDefault(v,0)+1);
        }

        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
            int a=e.getKey();
            int b=(a*1618)/1000; // floor(a*1.618)

            if(b!=a){
                if(freq.containsKey(b)){
                    System.out.println("Delicious!");
                    return;
                }
            }else{
                // 같은 양이 두 재료 이상 있는 경우
                if(e.getValue()>=2){
                    System.out.println("Delicious!");
                    return;
                }
            }
        }

        System.out.println("Not Delicious...");
    }
}
