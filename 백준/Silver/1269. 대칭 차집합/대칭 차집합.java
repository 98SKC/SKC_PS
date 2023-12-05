import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stN=new StringTokenizer(br.readLine());
        StringTokenizer stA=new StringTokenizer(br.readLine());
        StringTokenizer stB=new StringTokenizer(br.readLine());

        //map으로 더 편하게 되나.
        HashMap<Integer,Integer> map=new HashMap<>();

        int N=Integer.parseInt(stN.nextToken());
        int M=Integer.parseInt(stN.nextToken());
        int sub;
        int count=0;

        //int[] A=new int[N];
        //int[] B=new int[M];

        for(int i=0;i<N;i++){
            sub=Integer.parseInt(stA.nextToken());
            map.put(sub,map.getOrDefault(sub,0)+1);
            //A[i]=sub;
        }
        for(int j=0;j<M;j++){
            sub=Integer.parseInt(stB.nextToken());
            map.put(sub,map.getOrDefault(sub,0)+1);
            //B[j]=sub;
        }
        for(int answer:map.values()){
            if(answer==1) count++;
        }
        System.out.println(count);
    }
}
