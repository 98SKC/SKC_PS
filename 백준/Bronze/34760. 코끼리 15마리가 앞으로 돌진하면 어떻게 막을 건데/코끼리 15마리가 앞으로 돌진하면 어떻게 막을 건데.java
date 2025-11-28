

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //int[] elephants=new int[15];
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int last=0;
        int max=0;
        for(int i=0;i<15;i++){
        	//elephants[i]=Integer.parseInt(st.nextToken());
        	last=Integer.parseInt(st.nextToken());
        	map.put(last, map.getOrDefault(last, 0)+1);
        	max=Math.max(max, last);
        }
        int answer=-1;
        if(last==max&&map.get(max)==1) {
        	answer=max;
        }else {
        	answer=max+1;
        }
        
        System.out.println(answer);
        
        //당근으로 코끼리들의 돌진을 막는다
        //당근이 코끼리코보다 작으면 먹고 돌진, 같으면 먹고 수면, 크면 먹지도 않고 기절
        
        //마지막 코끼리가 최대이며 유일하면 당근의 최대크기는 코끼리의 최대 크기.
        //최대가 여러개이고, 마지막 코끼리가 최대가 아니면 최대의 +1
        
        
    }
        
}


